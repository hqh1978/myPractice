package org.example.myPractice.JobScheduling;

import java.util.Arrays;

public class JobScheduling {
    // 一个表示工作的类
    static class Job {
        int id;     // 工作的 ID
        int profit; // 工作的利润
        int deadline; // 工作的截止日期

        Job(int id, int profit, int deadline) {
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
                new Job(5, 1, 3)
        };
        int n = jobs.length;
        // 第一步：按利润降序排序
        Arrays.sort(jobs, (Job j1, Job j2)-> {
                return j2.profit - j1.profit;
            });

        // 第二步：找出最大截止日期
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // 第三步：创建一个数组来跟踪时间槽的使用情况
        boolean[] slots = new boolean[maxDeadline + 1]; // slots[0] 不使用
        int maxProfit = 0;
        for (Job job : jobs) {
            // 为这个工作找到一个时间槽
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true; // 标记时间槽为已占用
                    maxProfit += job.profit; // 累加利润
                    break; // 处理下一个工作
                }
            }
        }
        System.out.println("最大利润: " + maxProfit);
    }
}
