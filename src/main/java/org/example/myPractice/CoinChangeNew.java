package org.example.myPractice;

import java.util.Arrays;

public class CoinChangeNew {
    // 主方法
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 25};
        int amount = 13;
        int result = coinChange(coins, amount);
        System.out.println("凑成金额 " + amount + " 所需的最少硬币数量: " + result); // 输出: 3 (11 = 5 + 5 + 1)
    }

    // 计算最少硬币数的方法
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; //数组长度是找零数+1
        Arrays.fill(dp, Integer.MAX_VALUE);  //填充极大值
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //开始填充dp
            for (int coin : coins) {
                //钱数比面额大,且用掉当前面额后(用掉一个硬币)，要看的dp[面额]已被填好
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); //dp[i]=min(dp[i],dp[i-coin]+1)
                }
            }
            System.out.print(dp[i] + ",");
        }
        if (dp[amount] == Integer.MAX_VALUE) { // if(dp[amount]>amount) 找不开
            return -1;
        } else {
            return dp[amount];
        }
    }


}
