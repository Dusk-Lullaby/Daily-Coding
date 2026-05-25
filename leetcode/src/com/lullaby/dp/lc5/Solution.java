package com.lullaby.dp.lc5;


class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len - 1;
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && j - i > end - start) {
                        end = j;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}