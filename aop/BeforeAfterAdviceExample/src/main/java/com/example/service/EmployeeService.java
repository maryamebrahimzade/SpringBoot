package com.example.service;

import com.example.models.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public Employee createEmployee(String empId, String fName, String sName)
    {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setFirstName(fName);
        emp.setSecondName(sName);
        return emp;
    }
    public void deleteEmployee(String empId)
    {
    }

    public void getName(){
        System.out.println("test");
    }
}
