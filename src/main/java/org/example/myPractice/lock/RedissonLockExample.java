package org.example.myPractice.lock;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedissonLockExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建 Redisson 客户端配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        // 创建 Redisson 客户端
        RedissonClient redisson = Redisson.create(config);

        // 获取分布式锁
        RLock rlock = redisson.getLock("myLock");

        try {
            // 尝试获取锁
            if (rlock.tryLock(10, 100, TimeUnit.SECONDS)) {
                // 执行需要加锁的操作
                System.out.println("Lock acquired!");

                // 模拟操作
                Thread.sleep(5000);

            } else {
                System.out.println("Unable to acquire lock");
            }
        } finally {
            // 释放锁
            rlock.unlock();
            System.out.println("Lock released");
        }

        // 关闭 Redisson 客户端
        redisson.shutdown();
    }
}
