package com.lullaby.dp.linear_dp.luogu_p2758;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = " " + scanner.next();
        String target = " " + scanner.next();
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        int sourceLength = sourceChars.length;
        int targetLength = targetChars.length;
        int[][] DP = new int[sourceLength][targetLength];
        for (int i = 0; i < sourceLength; i++) {
            DP[i][0] = i;
        }
        for (int i = 0; i < targetLength; i++) {
            DP[0][i] = i;
        }

        for (int i = 1; i < sourceLength; i++) {
            for (int j = 1; j < targetLength; j++) {
                if (sourceChars[i] == targetChars[j]) {
                    DP[i][j] = DP[i - 1][j - 1];
                } else {
                    // 替换：DP[i][j] = 1 + DP[i - 1][j - 1]
                    // 插入：DP[i][j] = 1 + DP[i][j - 1]
                    // 删除：DP[i][j] = 1 + DP[i - 1][j]
                    DP[i][j] = Math.min(1 + DP[i - 1][j - 1], Math.min(1 + DP[i][j - 1], 1 + DP[i - 1][j]));
                }
            }
        }
        System.out.println(DP[sourceLength - 1][targetLength - 1]);
    }
}
