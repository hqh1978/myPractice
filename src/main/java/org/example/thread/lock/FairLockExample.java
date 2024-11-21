package org.example.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private final ReentrantLock lock = new ReentrantLock(true); // 创建公平锁

    public void someMethod() {
        lock.lock(); // 获取锁
        try {
            // 线程安全的代码
        } finally {
            lock.unlock(); // 释放锁
        }
    }
}
