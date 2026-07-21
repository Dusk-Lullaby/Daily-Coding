package com.lullaby.dp.lc121;

//class Solution {
//    public int maxProfit(int[] prices) {
//        // [7,1,5,3,6,4]
//        // dp[i][j] = max(dp[i][j - 1], arr[i] - arr[j])
//        int[][] dp = new int[prices.length + 1][prices.length + 1];
//        for (int i = 1; i <= prices.length; i++) {
//            for (int j = i; j <= prices.length; j++) {
//                dp[i][j] = Math.max(dp[i][j - 1], Math.max(prices[j - 1] - prices[i - 1], dp[i - 1][prices.length]));
//            }
//        }
//        return dp[prices.length][prices.length];
//    }
//}

class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] dp = new int[length + 1];
        // dp[i] = max(dp[i - 1], arr[i] - start)
        int start = prices[0];
        for (int i = 1; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - start);
            start = Math.min(start, prices[i - 1]);
        }

        return dp[length];
    }
}