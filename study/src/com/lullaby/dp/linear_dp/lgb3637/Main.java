package com.lullaby.dp.linear_dp.lgb3637;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
        }
        int[] DP = new int[n];
        Arrays.fill(DP, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (number[i] > number[j]) {
                    DP[i] = Math.max(DP[j] + 1, DP[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, DP[i]);
        }

        System.out.println(ans);
    }
}
