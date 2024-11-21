package org.example.myPractice.agent;

public class ServiceProxy implements Service{
    private RealService realService;
    public ServiceProxy(RealService realService) {
        this.realService = realService;
    }
    @Override
    public void execute() {
        System.out.println("Before execution.");
        realService.execute();
        System.out.println("After execution.");
    }
}
