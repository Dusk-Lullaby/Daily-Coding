package com.lullaby.dp.linear_dp.lc1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        text1 = " " + text1;
        text2 = " " + text2;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] DP = new int[len1][len2];
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (chars1[i] == chars2[j]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        return DP[len1 - 1][len2 - 1];
    }
}
