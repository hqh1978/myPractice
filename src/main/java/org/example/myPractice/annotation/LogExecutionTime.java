package org.example.myPractice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 可以用于方法
@Retention(RetentionPolicy.RUNTIME) // 在运行时保留
public @interface LogExecutionTime {
}
