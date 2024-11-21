package org.example.myPractice.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler {
    private Object target;

    ServiceInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before execution.");
        Object result = method.invoke(target, args);
        System.out.println("After execution.");
        return result;
    }
}
