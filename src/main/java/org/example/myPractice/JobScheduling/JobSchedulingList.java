package org.example.myPractice.JobScheduling;

import java.util.ArrayList;
import java.util.List;

public class JobSchedulingList {
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
        List<Job> myList = new ArrayList<Job>();
        myList.add(new Job(1, 20, 2));
        myList.add(new Job(2, 15, 2));
        myList.add(new Job(3, 10, 1));
        myList.add(new Job(4, 5, 3));
        myList.add(new Job(5, 1, 3));
        myList.sort((job1,job2)-> Integer.compare(job2.profit, job1.profit) );
        myList.forEach(System.out::println);

        // 第二步：找出最大截止日期
        int maxDeadline = 0;
        for (Job job : myList) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        // 第三步：创建一个数组来跟踪时间槽的使用情况
        boolean[] slots = new boolean[maxDeadline + 1]; // slots[0] 不使用
        int maxProfit = 0;
        for (Job job : myList) {
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