package com.becoder.employee.service;

import com.becoder.entity.Employee;
import com.becoder.employee.model.EmployeUpdateModel;
import com.becoder.employee.model.TaskInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeeUserService {
    public String updateEmployee(EmployeUpdateModel employeUpdateModel);

    Optional<Employee> getEmployyeById(int id);

    List<TaskInfo> getTaskListByEmpoyee(int id);
}
