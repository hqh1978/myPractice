//package org.example.myPractice.annotation;
//
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//    @Pointcut("@annotation(logExecutionTime)")
//    public void logExecutionTimePointcut(LogExecutionTime logExecutionTime) {
//
//    }
//
//    @Around("logExecutionTimePointcut(logExecutionTime)")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
//        long start = System.currentTimeMillis();
//
//        Object proceed = joinPoint.proceed(); // 执行被通知的方法
//
//        long executionTime = System.currentTimeMillis() - start;
//
//        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
//        return proceed;
//    }
//}
