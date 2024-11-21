package org.example.myPractice.mutiThread.countDownLatch;

import javafx.concurrent.Task;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample{
    public static void main(String[] args) throws InterruptedException {
        //countdownlatch 用于控制线程的执行顺序。  latch.await(); 后面的代码要等到countdownLatch清零以后才能被调用执行。
        int numberOfThreads = 3;
        // 创建一个计数器为3的CountDownLatch
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        // 创建3个线程，每个线程执行完成后调用 countDown
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Task(latch)).start();
        }

        // 主线程等待，直到计数器为0
        latch.await();  // 这里会阻塞主线程，直到其他线程调用 countDown()
        System.out.println("All tasks are completed, now main thread can proceed.");
    }

    static class Task implements Runnable {
        private CountDownLatch latch;

        Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // 模拟任务执行
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " has finished task.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();  // 每个线程完成后减少计数
            }
        }
    }
}
