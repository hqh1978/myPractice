package org.example.myPractice.mutiThread;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000); // 模拟长时间运行的任务
                System.out.println("Thread 1 completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
        });
        thread1.start();
        thread2.start();

        thread1.join(); // 等待 thread1 完成
        thread2.join(); // 等待 thread2 完成

        System.out.println("Both threads have finished");

    }
}
