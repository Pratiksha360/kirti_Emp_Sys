package com.becoder.employee.controller;


import com.becoder.employee.service.EmployeeUserService;
import com.becoder.entity.Employee;
import com.becoder.employee.model.EmployeUpdateModel;
import com.becoder.employee.model.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeUserService employeeUserService;
    @PutMapping("/updateemployee")
    public String updateEmployee(@RequestBody EmployeUpdateModel employeUpdateModel)
    {
        return employeeUserService.updateEmployee(employeUpdateModel);
    }

    @GetMapping("/getemployeeProfile/{id}")
    public Optional<Employee> getEmployyeById(@PathVariable int id)
    {
        Optional<Employee> employee=
         employeeUserService.getEmployyeById(id);
        return employee;
    }
    @GetMapping("/gettaskbyemployee/{id}")
    public List<TaskInfo> getTaskListByEmpoyee(@PathVariable int id)
    {
        return employeeUserService.getTaskListByEmpoyee(id);
    }
}
