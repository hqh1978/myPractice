package org.example.myPractice.knapsack;
//0/1 背包问题
public class Knapsack {
    public static void main(String[] args) {

        int[] weights = {2, 3, 5, 7, 1, 4, 1};
        int[] costs = {10, 5, 15, 7, 6, 18, 3};
        int capacity=15;
        // 调用背包算法
        int maxProfit = knapsack(weights,costs,capacity);
        System.out.println("最大利润: " + maxProfit);
    }

    private static int knapsack(int[] weights, int[] costs, int capacity) {
        int amount = weights.length; // 商品数量
        int dp[] = new int[capacity + 1]; // dp数组，表示每个容量下的最大利润，假设已经计算出来了。
        for (int i = 0; i < amount; i++) {
            //从空背包开始，能放15 ，尝试放这amount个商品，j > weight[i] 表示放得下，即找得开前
            for (int j = capacity; j > weights[i]; j--) {
                //dp[j - weights[i]]------当前容量-当前容量被占掉weights[i] 后对应dp数组里存的那个容量的最大利润值,
                // 然后再加上如果背包里加上了这件物品会增加到多少利润，和已有的dp里的值做比较，取大的。
                dp[i]=Math.max(dp[j],dp[j]-dp[j - weights[i]] + costs[i]);
            }
        }
        return dp[capacity];
    }

    // 0/1 背包问题的动态规划实现
    public static int knapsack2(int W, int[] weights, int[] values, int n) {
        // dp[i][w] 表示前 i 个物品中，背包容量为 w 时的最大价值
        int[][] dp = new int[n + 1][W + 1];

        // 填充 dp 数组
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    // 物品 i 可以放入背包，取放与不放的最大值
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // 物品 i 不能放入背包
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 返回最大价值
        return dp[n][W];
    }
}
