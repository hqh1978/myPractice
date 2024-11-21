package org.example.myPractice;

public class ModuloExpression {
    public static void main(String[] args) {
        long s = 3; // 替换为你的 s 值
        long N = 4; // 替换为你的 N 值
        long x = 5; // 替换为你的 x 值
        long M = 2; // 替换为你的 M 值
        long Y = 7; // 替换为你的 Y 值

        long result = moduloExpression(s, N, x, M, Y);
        System.out.println("结果为: " + result);
    }

    public static long moduloExpression(long s, long N, long x, long M, long Y) {
        // 计算 (s^N % x)
        long firstMod = modPower(s, N, x);

        // 计算 ((s^N % x) ^ M % Y)
        long secondMod = modPower(firstMod, M, Y);

        return secondMod;
    }

    // 计算 (base^exp % mod)
    public static long modPower(long base, long exp, long mod) {
        if (exp == 0) {
            return 1;
        }

        long half = modPower(base, exp / 2, mod) % mod;
        long halfSquared = (half * half) % mod;

        if (exp % 2 == 0) {
            return halfSquared;
        } else {
            return (base * halfSquared) % mod;
        }
    }
}
