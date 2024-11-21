package org.example.myPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 25};
        int amount = 157;
        Map<Integer, Integer> result = coinChange(coins, amount);
        if (result != null) {
            System.out.println("凑成金额 " + amount + " 所需的硬币种类和数量:");
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                System.out.println("硬币面值: " + entry.getKey() + " 数量: " + entry.getValue());
            }
        }
    }

    public static Map<Integer, Integer> coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int[] coinCount = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为无穷大
        dp[0] = 0; // 凑成金额0需要0个硬币

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != amount + 1) {
                    if (dp[i] > dp[i - coin] + 1) {
                        dp[i] = dp[i - coin] + 1;
                        coinCount[i] = coin;
                    }
                }
            }
        }

        if (dp[amount] > amount) {
            System.out.println("无法凑成该金额");
            return null; // 表示无法凑成该金额
        }

        // 计算每种硬币的数量
        Map<Integer, Integer> coinMap = new HashMap<>();
        int tempAmount = amount;
        while (tempAmount > 0) {
            int coin = coinCount[tempAmount];
            coinMap.put(coin, coinMap.getOrDefault(coin, 0) + 1);
            tempAmount -= coin;
        }

        return coinMap;
    }


}
