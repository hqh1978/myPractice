package org.example.myPractice.mutiThread;

// 运行时异常
public class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message);
    }
}