package com.lullaby.template;

public class lcm {
    public static void main(String[] args) {
        int a = 9;
        int b = 8;
        System.out.println(lcm(a, b));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
