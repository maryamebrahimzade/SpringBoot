package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAfterAspect {

    @After("args(name)")
    public void logStringArguments(String name){
        System.out.println("Running After Advice. String argument passed="+name);
    }

    @AfterThrowing("within(com.example.services.EmployeeService)")
    public void logExceptions(JoinPoint joinPoint){
        System.out.println("Exception thrown in Employee Method="+joinPoint.toString());
    }

    @AfterReturning(pointcut="execution(* getMessage())", returning="returnString")
    public void getNameReturningAdvice(String returnString){
        System.out.println("getMessageReturningAdvice executed. Returned String="+returnString);
    }
}
