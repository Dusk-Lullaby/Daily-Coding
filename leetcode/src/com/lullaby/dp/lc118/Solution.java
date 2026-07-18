package com.lullaby.dp.lc118;


import java.util.ArrayList;
import java.util.List;

/*
    1
    1 1
    1 2 1
    1 3 3 1
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>());
        }
        // num[i, j] = dp[i - 1, j - 1] + dp[i - 1, j];
        // 初始化
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = res.get(i);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            list.add(1);
        }

        return res;
    }
}