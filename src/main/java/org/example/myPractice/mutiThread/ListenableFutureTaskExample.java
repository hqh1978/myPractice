package org.example.myPractice.mutiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;

public class ListenableFutureTaskExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 创建 ListenableFutureTask
        ListenableFutureTask<Integer> futureTask = ListenableFutureTask.create(() -> {
            try {
                // 模拟长时间运行的任务
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        // 添加回调函数
        futureTask.addListener(() -> {
            try {
                // 处理结果
                Integer result = futureTask.get();
                System.out.println("Result: " + result);
            } catch (Exception e) {
                // 处理异常
                System.out.println("Error: " + e.getMessage());
            }
        }, MoreExecutors.directExecutor());

        // 提交任务到 ExecutorService
        executorService.submit(futureTask);

        // 主线程继续执行其他工作
        System.out.println("Main thread doing other work...");

        // 关闭 ExecutorService
        executorService.shutdown();
    }
}
