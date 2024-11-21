package org.example.myPractice;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static void main(String[] args) {
        int x = 30; // 可以根据需要更改 x 的值
        List<Integer> primes = findPrimes(x);

        System.out.println("质数小于等于 " + x + " 的数有:");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }

    public static List<Integer> findPrimes(int x) {
        /**
         * 在这个示例中，我们定义了一个 findPrimes 方法来找出小于等于
         * 𝑥
         * x 的所有质数。这里使用了埃拉托斯特尼筛法（Sieve of Eratosthenes），
         * 这是一种高效的算法来找出一定范围内的所有质数。具体步骤包括：
         *
         * 初始化一个布尔数组 isPrime，将所有大于等于 2 的数都标记为质数。
         * 使用循环从 2 开始，标记其倍数为非质数。
         * 收集所有未被标记为非质数的数，即质数。
         * 运行示例代码，输出将会是小于等于给定数
         * 𝑥
         * x 的所有质数。例如，如果将
         * 𝑥
         * x 设置为 30，输出将会是小于等于 30 的所有质数：2 3 5 7 11 13 17 19 23 29。
         */
        List<Integer> primes = new ArrayList<>();
        if (x < 2) {
            return primes;
        }

        // 使用一个布尔数组来标记质数和非质数
        boolean[] isPrime = new boolean[x + 1];
        for (int i = 2; i <= x; i++) {
            isPrime[i] = true; // 先假设所有数都是质数
        }

        // 使用埃拉托斯特尼筛法找出所有质数
        for (int p = 2; p * p <= x; p++) {
            if (isPrime[p]) {
                // 将 p 的倍数标记为非质数
                for (int i = p * p; i <= x; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // 收集所有质数到结果列表中
        for (int i = 2; i <= x; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}
