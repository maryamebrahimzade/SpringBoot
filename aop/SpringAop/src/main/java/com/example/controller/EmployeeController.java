package com.example.controller;

import com.example.models.Employee;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

   // @RequestMapping(value = "/get/employee", method = RequestMethod.GET)
    @GetMapping
    public Employee getEmployee()
    {
       return employeeService.getEmployee();
    }

    @GetMapping("/message")
    public String printEmployee()
    {
        return employeeService.getMessage();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String print(@RequestParam("name") String name)
    {
        return employeeService.getNameEmployee(name);
    }

    @RequestMapping(value = "/set/employee", method = RequestMethod.GET)
    public void setEmployee(Employee name)
    {
        employeeService.setEmployee(name);
    }

    @GetMapping("/exception")
    public void printException()
    {
        employeeService.throwException();
    }
}
