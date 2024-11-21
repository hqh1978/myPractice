package org.example.myPractice;

import java.util.Arrays;
import java.util.Comparator;

class Task {
    int arrivalTime;
    int executionTime;

    Task(int arrivalTime, int executionTime) {
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
    }
}
public class TaskScheduler {
    public static void main(String[] args) {
        Task[] tasks = {
                new Task(0, 3),
                new Task(1, 9),
                new Task(2, 6)
        };

        double averageWaitTime = calculateAverageWaitTime(tasks);
        System.out.println("平均等待时间: " + averageWaitTime);
    }
    public static double calculateAverageWaitTime(Task[] tasks) {
        // 按到达时间排序任务
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.arrivalTime));

        int currentTime = 0;
        int totalWaitTime = 0;

        for (Task task : tasks) {
            if (currentTime < task.arrivalTime) {
                currentTime = task.arrivalTime;
            }
            totalWaitTime += currentTime - task.arrivalTime;
            currentTime += task.executionTime;
        }

        return (double) totalWaitTime / tasks.length;
    }
}
