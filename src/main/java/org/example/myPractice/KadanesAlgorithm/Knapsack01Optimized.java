package org.example.myPractice.KadanesAlgorithm;

public class Knapsack01Optimized {

    public static void main(String[] args) {
        int capacity = 50; // 背包容量
        int[] weights = {10, 20, 30}; // 物品重量
        int[] values = {60, 100, 120}; // 物品价值
        int n = weights.length; // 物品数量

        int maxValue = knapsack(capacity, weights, values, n);
        System.out.println("最大价值是: " + maxValue);
    }

    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        // 一维数组 dp[i] 表示背包容量为 i 时的最大价值
        int[] dp = new int[capacity + 1];

        // 遍历每个物品
        for (int i = 0; i < n; i++) {
            // 从背包容量 W 50 到 物品重量 weights[i] {10, 20, 30}--->币种 逆序遍历，确保每个物品只被使用一次
            for (int k = capacity;  k>= weights[i]; k--) {
                dp[k] = Math.max(dp[k], dp[k - weights[i]] + values[i]);
            }
        }

        // dp[W] 为背包容量为 W 时的最大价值
        return dp[capacity];
    }


}
