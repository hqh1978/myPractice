package org.example.myPractice.SingletonTest;

/**
 * 饿汉式单例模式在类加载时就创建实例。
 * 优点是简单且没有多线程问题，但如果实例占用资源较多，可能会导致资源浪费。
 */
public class EagerSingleton {
    private static final EagerSingleton instance =new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
