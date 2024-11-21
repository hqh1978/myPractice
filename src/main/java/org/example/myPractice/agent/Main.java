package org.example.myPractice.agent;

public class Main {
    public static void main(String[] args) {
        ServiceProxy serviceProxy=new ServiceProxy(new RealService());
        serviceProxy.execute();
    }
}
