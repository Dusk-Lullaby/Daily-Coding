package com.lullaby.dp.lc119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
        }
        return lists.get(rowIndex);
    }
}