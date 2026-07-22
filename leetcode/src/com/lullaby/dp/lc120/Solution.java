package com.lullaby.dp.lc120;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (List<Integer> list : triangle) {
            dp.add(new ArrayList<>());
        }

        // dp[i, j] = Math.min(dp[i - 1, j], dp[i - 1][j - 1]) + arr[i, j];
        dp.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int num = triangle.get(i).get(j);
                if (j == 0) {
                    dp.get(i).add(dp.get(i - 1).get(j) + num);
                } else if (j == i) {
                    dp.get(i).add(dp.get(i - 1).get(j - 1) + num);
                } else {
                    dp.get(i).add(Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j - 1)) + num);
                }
            }
        }
        int ans = 0x3f3f3f3f;
        for (int i : dp.get(triangle.size() - 1)) {
            ans = Math.min(ans, i);
        }
        return ans;
    }
}