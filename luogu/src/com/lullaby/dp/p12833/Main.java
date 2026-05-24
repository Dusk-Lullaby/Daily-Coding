package com.lullaby.dp.p12833;

import java.util.Scanner;

public class Main {

    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        if (max == 1 || max == 2) max = 3;
        long[] ones = new long[max + 1];
        long[] zeros = new long[max + 1];
        long[] dp = new long[max + 1];
        ones[2] = 1;
        zeros[1] = 1;
        for (int j = 3; j <= max; j++) {
            ones[j] = (ones[j - 2] + ones[j - 1]) % MOD;
            zeros[j] = (zeros[j - 2] + zeros[j - 1]) % MOD;
            dp[j] = (dp[j - 1] + dp[j - 2] + (ones[j - 2] * zeros[j - 1] % MOD)) % MOD;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[nums[i]]);
        }
    }
}
