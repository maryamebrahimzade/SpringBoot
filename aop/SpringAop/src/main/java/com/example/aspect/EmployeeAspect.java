package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {
    @Before("execution(public String getNameEmployee(..)) and args(name)")
    public void getNameAdvice(String name) {
        System.out.println("After Advice: Executing Advice on getNameEmployee()");
    }

    @Before("execution(* com.example.services.*.get*())")
    public void getAllAdvice(JoinPoint joinPoint) {
        System.out.println("Before Advice: "+ joinPoint);
    }
}
