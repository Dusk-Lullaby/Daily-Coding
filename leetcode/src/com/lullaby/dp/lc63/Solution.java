package com.lullaby.dp.lc63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid.length;
        int row = obstacleGrid[0].length;
        int[][] dp = new int[col + 1][row + 1];
        int temp = 1;
        for (int i = 1; i <= col; i++) {
            if (obstacleGrid[i - 1][0] == 1) {
                temp = 0;
            }
            dp[i][1] = temp;
        }
        temp = 1;
        for (int i = 1; i <= row; i++) {
            if (obstacleGrid[0][i - 1] == 1) {
                temp = 0;
            }
            dp[1][i] = temp;
        }
        for (int i = 2; i <= col; i++) {
            for (int j = 2; j <= row; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[col][row];
    }
}