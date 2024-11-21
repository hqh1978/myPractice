package org.example.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    /**
     * synchronized 自动管理锁的获取和释放，不需要显式调用。
     * Lock 需要显式地调用 lock() 和 unlock() 方法，提供更灵活的控制。
     * 显式控制：需要显式地获取和释放锁。提供了更细粒度的控制。
     * 可中断锁：Lock 可以设置为中断响应，允许线程在等待锁时响应中断。
     * Lock 可以响应中断，提供了 tryLock(long timeout, TimeUnit unit)
     * 方法来尝试获取锁，并可以在超时后中断等待。
     * ReentrantLock 提供了公平锁选项，可以选择在构造时指定是否公平。
     * synchronized 使用内置的 wait() 和 notify() 方法来实现线程协作。
     * Lock 提供了 Condition 对象，支持更复杂的等待/通知机制。
     */
    private final Lock lock = new ReentrantLock();

    public void someMethod() {
        lock.lock(); // 获取锁
        try {
            // 线程安全的代码
        } finally {
            lock.unlock(); // 确保锁释放
        }
    }
}
