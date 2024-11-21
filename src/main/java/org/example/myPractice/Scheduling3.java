package org.example.myPractice;

import java.util.Arrays;

public class Scheduling3 {
    public static void main(String[] args) {
        int[] processingTimes = {2, 5, 1}; // 示例任务处理时间
        double averageWaitTime = minAverageWaitTime(processingTimes);
        System.out.println("Minimum Average Waiting Time: " + averageWaitTime);
    }

    public static double minAverageWaitTime(int[] times) {
        int n = times.length;
        // 任务处理时间升序排序
        Arrays.sort(times);

        int totalWaitTime = 0;
        int currentWaitTime = 0;

        // 计算总等待时间
        for (int time : times) {
            totalWaitTime = totalWaitTime + currentWaitTime;
            currentWaitTime = currentWaitTime + time;
        }

        // 返回平均等待时间
        return (double) totalWaitTime / n;
    }
}
