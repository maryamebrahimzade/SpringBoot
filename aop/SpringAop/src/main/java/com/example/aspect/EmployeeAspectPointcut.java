package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspectPointcut {
    @Pointcut("execution(public String getMessage())")
    public void getNamePointcut() {
    }

    @Before("getNamePointcut()")
    public void loggingAdvice(){
        System.out.println("Executing loggingAdvice on getMessage()");
    }

    @Before("getNamePointcut()")
    public void secondAdvice(){
        System.out.println("Executing secondAdvice on getMessage()");
    }

    //Pointcut to execute on all the methods of classes in a package
    @Pointcut("within(com.example.services.*)")
    public void allMethodsPointcut(){}

    @Before("allMethodsPointcut()")
    public void allServiceMethodsAdvice(){
        System.out.println("Example Within->Before executing service method");
    }


}
