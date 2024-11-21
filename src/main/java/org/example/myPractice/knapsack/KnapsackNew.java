package org.example.myPractice.knapsack;
//0/1 背包问题
public class KnapsackNew {

        // 完全背包问题的动态规划解法
        public static int knapsack(int[] weights, int[] values, int W) {
            int n = weights.length;
            int[] dp = new int[W + 1];  // dp[i] 表示背包容量为 i 时的最大价值

            // 遍历每个物品
            for (int i = 0; i < n; i++) {
                // 从前往后遍历背包容量，确保每个物品最多使用一次
                for (int w = weights[i]; w <= W; w++) {
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                }
            }

            return dp[W];  // 返回背包容量为 W 时的最大价值
        }

        public static void main(String[] args) {
            int[] weights = {2, 3, 4, 5}; // 物品的重量
            int[] values = {3, 4, 5, 6};  // 物品的价值
            int W = 5;  // 背包的最大容量

            System.out.println("Maximum value: " + knapsack(weights, values, W));
        }
    }

