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

    // 埃氏筛: 时间复杂度 O(n log log n)
    // 核心思想: 从2开始，每找到一个质数，就把它的所有倍数标记为合数
    // 优化: 从 i*i 开始标记，因为小于 i*i 的倍数之前已经被更小的质数标记过了
    public static int[] EratosthenesSieve(int n) {
        // isPrime[i] 表示数字 i 是否为质数
        boolean[] isPrime = new boolean[n + 1];
        // primes 存储所有找到的质数
        int[] primes = new int[n + 1];
        // count 记录当前找到的质数个数
        int count = 0;
        // 初始化: 假设 2~n 都是质数
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            // 如果 i 是质数，加入 primes 数组
            if (isPrime[i]) {
                primes[count++] = i;
            }

            // i <= n / i 等价于 i*i <= n，避免 int 溢出
            // 只有 i 是质数时才需要筛掉它的倍数
            if (i <= n / i) {
                // 从 i*i 开始，步长为 i，将所有倍数标记为合数
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return primes;
    }

    // 欧拉筛(线性筛): 时间复杂度 O(n)
    // 核心思想: 每个合数只被它最小的质因子筛掉一次，确保每个数只被标记一次
    // 关键: 当 i % primes[j] == 0 时 break，保证 primes[j] 是 i 的最小质因子
    public static int[] EulerSieve(int n) {
        // isPrime[i] 表示数字 i 是否为质数
        boolean[] isPrime = new boolean[n + 1];
        // primes 存储所有找到的质数
        int[] primes = new int[n + 1];
        // count 记录当前找到的质数个数
        int count = 0;
        // 初始化: 假设 2~n 都是质数
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            // 如果 i 是质数，加入 primes 数组
            if (isPrime[i]) {
                primes[count++] = i;
            }

            // 用每个已找到的质数去筛掉 i 的倍数
            for (int j = 0; j < count; j++) {
                int x = primes[j] * i;
                // 超出范围就停止
                if (x > n) break;
                // 将 primes[j] * i 标记为合数，primes[j] 是这个合数的最小质因子
                isPrime[x] = false;
                // 关键优化: 如果 i 能被 primes[j] 整除，说明 primes[j] 已经是 i 的最小质因子
                // 那么对于更大的质数 p > primes[j]，p*i 的最小质因子一定是 primes[j] 而不是 p
                // 所以 break 避免重复标记，保证每个合数只被筛一次
                if (i % primes[j] == 0) break;
            }
        }

        return primes;
    }
}
