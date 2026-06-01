package com.lullaby.dp.lc64;

class Solution {
    public int minPathSum(int[][] grid) {
        int col = grid.length;;
        int row = grid[0].length;
        int[][] dp = new int[col + 1][row + 1];
        dp[1][1] = grid[0][0];
        for (int i = 2; i <= col; i++) {
            dp[i][1] = dp[i - 1][1] + grid[i - 1][0];
        }
        for (int i = 2; i <= row; i++) {
            dp[1][i] = dp[1][i - 1] + grid[0][i - 1];
        }
        for (int i = 2; i <= col; i++) {
            for (int j = 2; j <= row; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[col][row];
    }
}