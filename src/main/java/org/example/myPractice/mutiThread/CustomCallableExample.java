package org.example.myPractice.mutiThread;

import java.util.concurrent.*;

public class CustomCallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<String> task = new CustomCallable();
        Future<String> future = executorService.submit(task);
        try {
            String result = future.get(); // 获取任务结果
            System.out.println(result);
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted");
        } catch (ExecutionException e) {
            System.err.println("Task execution failed");
            Throwable cause = e.getCause();
            if (cause instanceof CustomCheckedException) {
                System.err.println("CustomCheckedException occurred: " + cause.getMessage());
            } else {
                System.err.println("Other exception occurred: " + cause.getMessage());
            }
        } finally {
            executorService.shutdown(); // 关闭线程池
        }

    }
}
