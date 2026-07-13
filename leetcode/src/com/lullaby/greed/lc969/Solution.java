package com.lullaby.greed.lc969;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int num = arr.length;
        // 需要找的
        for (int i = num; i > 0; i--) {
            // index
            for (int j = 0; j < i; j++) {
                if (arr[j] == i) {
                    if (j == i - 1) continue;
                    res.add(j + 1);
                    reverse(arr, j);
                    res.add(i);
                    reverse(arr, i - 1);
                    break;
                }
            }
        }
        return res;
    }

    public void reverse(int[] arr, int index) {
        int left = 0;
        int right = index;
        while (left < right) {
            int temp;
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
