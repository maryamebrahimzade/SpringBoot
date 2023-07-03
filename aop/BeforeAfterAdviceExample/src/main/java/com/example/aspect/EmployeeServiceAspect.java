package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
    @Before(value = "execution(* com.example.service.EmployeeService.*(..)) and args(empId, fName, sName)")
    public void beforeAdvice(JoinPoint joinPoint, String empId, String fName, String sName) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Creating Employee with first name: " + fName + ", second name: " + sName + " and id: " + empId);
    }

    @After(value = "execution(* com.example.service.EmployeeService.*(..)) and args(empId, fname, sname)")
    public void afterAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);
    }
}
