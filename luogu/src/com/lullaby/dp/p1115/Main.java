package com.lullaby.dp.p1115;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = numbers[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[ i - 1] + numbers[i], numbers[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
