package org.example.myPractice.mutiThread;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable<String> {
    @Override
    public String call() throws CustomCheckedException {
        // 复杂操作，可能抛出自定义异常
        if (someConditionFails()) {
            throw new CustomCheckedException("Custom error occurred");
        }
        return "Task completed successfully";
    }

    private boolean someConditionFails() {
        // 逻辑判断
        return true;
    }
}
