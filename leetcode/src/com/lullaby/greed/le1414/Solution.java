package com.lullaby.greed.le1414;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int res = 0;
        int index = 1;
        int num = 2;
        while (num <= k) {
            list.add(num);
            index++;
            num = list.get(index) + list.get(index - 1);
        }
        k -= (list.get(index - 2) + list.get(index - 1));
        res++;
        while (k != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i + 1) > k) {
                    res++;
                    k -= list.get(i);
                    break;
                }
            }
        }
        return res;
    }
}