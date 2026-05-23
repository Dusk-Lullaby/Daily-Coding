package com.lullaby.dp.p4170;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] chars = string.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0x3f3f3f3f);
        }
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= chars.length; len++) {
            for (int i = 0; i <= chars.length - len; i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j]) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]);
                } else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j], dp[i][j]);
                    }
                }
            }
        }
        System.out.println(dp[0][chars.length - 1]);
    }
}
