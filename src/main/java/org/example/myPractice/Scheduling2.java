package org.example.myPractice;

import java.util.Arrays;

public class Scheduling2 {
    public static void main(String[] args) {
        int[] processingTimes = {2, 5, 1}; // 示例任务处理时间
        double averageWaitTime = minAverageWaitTime(processingTimes);
        System.out.println("Minimum Average Waiting Time: " + averageWaitTime);
    }
    public static double minAverageWaitTime(int[] times) {
        int n = times.length;
        int[] dp = new int[n + 1];
        int[] sumTime = new int[n + 1];

        // 计算前i个任务的总处理时间
        for (int i = 0; i < n; i++) {
            sumTime[i + 1] = sumTime[i] + times[i];
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 计算前 i 个任务的等待时间
        for (int i = 1; i <= n; i++) {
            int currentSum = 0;
            // 遍历可能的任务顺序
            for (int j = i; j >= 1; j--) {
                currentSum += times[j - 1];
                // 更新 dp[i] 为最小总等待时间
                dp[i] = Math.min(dp[i], dp[j - 1] + currentSum * (i - (j - 1)));
            }
        }

        return (double) dp[n] / n;
    }
}
