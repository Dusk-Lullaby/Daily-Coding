package com.lullaby.template;

public class PrimeSieve {
    public static void main(String[] args) {
        int n = 100;
        int[] primes = EratosthenesSieve(n);
        for (int i = 0; i <= n; i++) {
            if (primes[i] == 0) break;
            System.out.print(primes[i] + " ");
        }
        System.out.println();
        n = 200;
        primes = EulerSieve(n);
        for (int i = 0; i <= n; i++) {
            if (primes[i] == 0) break;
            System.out.print(primes[i] + " ");
        }

    }

    // 埃氏筛
    public static int[] EratosthenesSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int[] primes = new int[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[count++] = i;
            }

            if (i <= n / i) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return primes;
    }

    // 欧拉筛
    public static int[] EulerSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int[] primes = new int[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[count++] = i;
            }

            for (int j = 0; j < count; j++) {
                int x = primes[j] * i;
                if (x > n) break;
                isPrime[x] = false;
                if (i % primes[j] == 0) break;
            }
        }

        return primes;
    }
}
