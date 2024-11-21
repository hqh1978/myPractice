package org.example.myPractice;

import java.util.*;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int amount = 13;
        int result = coinChange4(coins, amount);
        System.out.println("凑成金额 " + amount + " 所需的最少硬币数量: " + result); // 输出: 3 (11 = 5 + 5 + 1)
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为无穷大
        dp[0] = 0; // 凑成金额0需要0个硬币
        for (int i = 1; i <= amount; i++) {     //买1分钱,2分钱，3分钱。。。。
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        // 将条件判断和返回值分开写
        if (dp[amount] > amount) {
            return -1; // 如果 dp[amount] 的值大于 amount，表示无法凑成该金额，返回 -1
        } else {
            return dp[amount]; // 否则返回 dp[amount]
        }
    }

    public static int coinChange2(int[] coins, int amount) {
        //在动态规划（Dynamic Programming）问题中，dp 通常是动态规划数组的简称。
        //dp[amount] 表示凑成指定金额 amount 所需要的最少硬币数量。
        /*
        dp数组：动态规划数组 dp 用于存储从 0 到 amount 不同金额的最优解。
        dp[i] 表示凑成金额 i 所需要的最少硬币数量。
        dp[0] 初始化为 0，因为凑成金额 0 需要 0 个硬币。
        其他 dp[i] 初始化为一个较大的数（如 amount + 1），表示初始状态下无法凑成该金额。
        动态规划的全称和核心概念
        动态规划（Dynamic Programming）是一种解决复杂问题的方法，通过将问题分解为更小的子问题来解决。
        它的核心思想是通过存储子问题的结果，避免重复计算，从而提高效率。
        */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为无穷大
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];   //把所有的钱数对应的货币数都算出来。
        Arrays.fill(dp, amount + 1);     //填入最大值。
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) { //如果要买的东西比一枚硬币的面值大
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    /**
     * 动态规划算法，是不是也有一定的假设思想。假设dp数组已经填好了，同时dp的base已经要填对，然后去调整这个dp数组的值。
     * 用dp数据前面的数据 加上一个推导出来的数学公式，来逐个计算出后面的值，然后填入即可
     *
     * 动态规划的核心思想总结：
     * 假设和推导：动态规划的关键在于推导递推公式或状态转移方程。我们通过假设 子问题的解已经求得，然后利用数学公式逐步计算出最终问题的解。
     *
     * 基础状态填充：通常我们首先会填充基础状态，这些状态是可以直接得出的。然后，逐步通过递推公式填充其余的状态。
     *
     * 逐步推进：在每一步中，我们利用已知的前面状态数据来推导新的状态，最终得到最优解。
     */
    public static int coinChange4(int[] coins, int amount) {
        // dp 状态数组
        int dp[] = new int[amount + 1];  //不同面额找硬币，需要的最少的硬币数量 假设已经知道了。
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 基础状态（base case）
        dp[0] = 0;  //这一步十分关键。 这个为数不多的条件，一定要用上。别浪费，十分有可能是base。。
        Map<Integer, List<Integer>> dpMap=new HashMap<>();
        for (int i = 1; i <= amount; i++) {  //这里从1开始，第一个数位置已经填0了
            List<Integer> detailList=new ArrayList<>();
            dpMap.put(i,detailList);
            for (int coin : coins) {
                if ((i - coin) >= 0) { //(i - coin=0) >= 0   这里=0也行，正好找开
                    //递推公式：然后，根据状态转移方程（或递推公式），逐个计算出后面的状态。
                    // 每个状态是通过 前面状态 和 当前决策 的组合来推导出来的。
                    //逐步填充：通过逐步填充 dp 数组，从而得到问题的解。每次填充都会用到前面已经填充的状态数据，这也是动态规划的核心思想。
//                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);  //递推公式 或 状态转移方程 这里就是dp[i - coin] + 1
                    if(dp[i]>(dp[i - coin] + 1)){
                        dp[i]=dp[i - coin] + 1;
                        detailList.add(coin);
                    }

                }
            }
        }
        return  dp[amount];
    }
}
