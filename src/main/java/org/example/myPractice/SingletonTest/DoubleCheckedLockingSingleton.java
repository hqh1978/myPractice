package org.example.myPractice.SingletonTest;

/**
 * 双重检查锁定在懒汉式的基础上，通过减少同步开销来提高性能。适用于多线程环境，同时避免了性能瓶颈。
 */
public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
        // 私有构造函数防止实例化
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
