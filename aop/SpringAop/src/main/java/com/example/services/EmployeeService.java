package com.example.services;

import com.example.models.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private Employee employee;

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee e) {
        e.setName("Hi");
        this.employee =e ;
    }

    public String getNameEmployee(String name) {
        return "Name of the employee: " + name;
    }

    public String getMessage() {
        return "Hello";
    }

    public void throwException(){
        throw new RuntimeException("Dummy Exception");
    }
}
