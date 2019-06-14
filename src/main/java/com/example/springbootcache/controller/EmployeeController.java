package com.example.springbootcache.controller;

import com.example.springbootcache.bean.Employee;
import com.example.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinji.li
 * @email lijinjilijinji@gmail.com
 * @date 2019/6/14
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer empId){
        Employee employee = employeeService.getEmp(empId);
        return employee;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        Employee employee1 = employeeService.updateEmp(employee);
        return  employee1;
    }

    @GetMapping("/delEmp")
    public String deleteEmp(Integer empId){
        employeeService.deleteEmp(empId);
        return "Success";
    }

}
