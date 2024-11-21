package org.example.myPractice.mutiThread;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListenableFutureCallbackExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 创建一个 ListenableFutureTask
        // 创建一个 ListenableFutureTask
        ListenableFutureTask<String> futureTask = new ListenableFutureTask<>(
                ()->{
                // 模拟长时间运行的任务
                Thread.sleep(2000);
                return "Task Completed";
        });
        ListenableFutureTask<String> futureTask2 = new ListenableFutureTask<>(
                () -> {
                // 模拟长时间运行的任务
            Thread.sleep(2000);
            return "Task Completed";
        });

        // 提交任务
        executor.submit(futureTask);

        // 添加回调
        futureTask.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Task completed successfully with result: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println("Task failed with exception: " + t.getMessage());
            }
        });

        // 关闭 executor
        executor.shutdown();
    }
}


