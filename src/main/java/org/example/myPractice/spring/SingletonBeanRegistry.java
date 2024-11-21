package org.example.myPractice.spring;

import org.springframework.beans.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonBeanRegistry {

    // 一级缓存：存储完全初始化的单例 bean
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 二级缓存：存储正在创建中的单例 bean 的早期引用
    private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>();

    // 三级缓存：存储用于创建单例 bean 的 ObjectFactory 实例
    private final Map<String, ObjectFactory<?>> singletonFactories = new ConcurrentHashMap<>();

    public Object getBean(String beanName) {
        // 尝试从一级缓存中获取 bean
        Object bean = singletonObjects.get(beanName);
        if (bean == null) {
            // 如果一级缓存中没有，尝试从二级缓存中获取早期引用
            bean = earlySingletonObjects.get(beanName);
            if (bean == null) {
                // 如果二级缓存中也没有，尝试从三级缓存中获取 ObjectFactory 并通过它创建 bean
                ObjectFactory<?> factory = singletonFactories.get(beanName);
                if (factory != null) {
                    bean = factory.getObject();
                    // 将早期引用放入二级缓存中
                    earlySingletonObjects.put(beanName, bean);
                }
            }
        }
        return bean;
    }

    public void addBean(String beanName, Object bean) {
        // 将完全初始化的 bean 放入一级缓存中
        singletonObjects.put(beanName, bean);
        // 从二级缓存和三级缓存中移除该 bean
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    public void addFactory(String beanName, ObjectFactory<?> factory) {
        // 将 ObjectFactory 实例放入三级缓存中
        singletonFactories.put(beanName, factory);
    }
}

