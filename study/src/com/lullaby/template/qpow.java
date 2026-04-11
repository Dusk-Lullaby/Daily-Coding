package com.lullaby.template;

public class qpow {
    public static void main(String[] args) {
        long base = 2;
        long exr = 10;
        long mod = 10000000;
        System.out.println(qpow(base, exr, mod));
    }

    public static long qpow(long base, long exr, long mod) {
        base = base % mod;
        long res = 1;
        while (exr > 0) {
            if ((exr & 1) == 1) {
                res = res * base % mod;
            }

            exr >>= 1;
            base = base * base % mod;
        }

        return res;
    }
}
