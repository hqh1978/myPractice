package org.example.myPractice.agent;

import java.lang.reflect.Proxy;

public class Main2 {
    public static void main(String[] args) {
        RealService realService = new RealService();
        Service proxy = (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                realService.getClass().getInterfaces(),
                new ServiceInvocationHandler(realService)
        );
        proxy.execute();
    }
}
