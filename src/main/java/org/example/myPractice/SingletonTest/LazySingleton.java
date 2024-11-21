package org.example.myPractice.SingletonTest;

/**
 * 懒汉式单例模式在第一次调用getInstance方法时创建实例。优点是延迟加载，
 * 但在多线程环境下需要额外的同步机制来确保线程安全。
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            return new LazySingleton();
        }
        return instance;
    }
}
