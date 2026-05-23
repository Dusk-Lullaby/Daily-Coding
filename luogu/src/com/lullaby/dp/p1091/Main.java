package com.lullaby.dp.p1091;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        // 上升
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] > numbers[i]) {
                    dp1[j] = Math.max(dp1[i] + 1, dp1[j]);
                }
            }
        }
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] > numbers[i]) {
                    dp2[j] = Math.max(dp2[i] + 1, dp2[j]);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = Math.max(dp1[i] + dp2[i] - 1, count);
        }
        System.out.println(n - count);
    }
}
