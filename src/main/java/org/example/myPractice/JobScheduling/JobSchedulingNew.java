package org.example.myPractice.JobScheduling;

import java.util.Arrays;

public class JobSchedulingNew {
    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 20, 2),
                new Job(2, 15, 2),
                new Job(3, 10, 1),
                new Job(4, 5, 3),
                new Job(5, 1, 3),
                new Job(6, 70, 3)
        };
        // 第一步：按利润降序排序
        Arrays.sort(jobs, (a, b) -> {
            return (b.profit - a.profit);
        });
        // 第二步：找出最大截止日期
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);
        int maxProfit = 0;
        //为这个工作找到一个时间槽
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = job.id;
                    maxProfit = maxProfit + job.profit;
                    break;
                }
            }
        }
        System.out.println("最大利润: " + maxProfit);
    }
}
