package org.example.myPractice;
import java.util.Arrays;
public class Scheduling {
    public static void main(String[] args) {
        int[] processingTimes = {3, 5, 2,7}; // 示例任务处理时间
        double averageWaitTime = minAverageWaitTime(processingTimes);
        System.out.println("Minimum Average Waiting Time: " + averageWaitTime);
    }
    public static double minAverageWaitTime(int[] times) {
        int n = times.length;
        int[] dp = new int[n + 1];
        int[] sumTime = new int[n + 1];
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sumTime[i] = sum + times[i-1];
            sum = sumTime[i];
        }

        // 计算前i个任务的总处理时间
    /*
        for (int i = 0; i < n; i++) {
            sumTime[i + 1] = sumTime[i] + times[i];
        }
    */

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int waitTime = sumTime[i] - sumTime[j];
                dp[i] = Math.min(dp[i], dp[j] + waitTime * (i - j));
                //sumTime[i] - sumTime[j] 表示任务 j+1 到任务 i 的总处理时间。
                //dp[i] =  Math.min(dp[i],dp[j] + sumTime[i] - sumTime[j]);
            }
        }
        return (double) dp[n]/n;
    }
}
