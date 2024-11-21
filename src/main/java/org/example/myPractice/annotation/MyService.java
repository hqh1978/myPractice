package org.example.myPractice.annotation;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    @LogExecutionTime
    public void performTask() {
        // 模拟任务执行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void anotherTask() {
        // 另一个任务
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
