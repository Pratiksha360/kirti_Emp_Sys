package com.becoder.employee.service;

import com.becoder.entity.Employee;
import com.becoder.repository.EmpRepository;
import com.becoder.employee.model.EmployeUpdateModel;
import com.becoder.employee.model.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeUserServiceImpl implements EmployeeUserService {
    @Autowired
    EmpRepository empRepository;
    @Override
    public String updateEmployee(EmployeUpdateModel employeUpdateModel) {
        String result="";

        try {
            Employee employee=empRepository.getById(employeUpdateModel.getId());
            employee.setAddress(employeUpdateModel.getAddress());
            employee.setGender(employeUpdateModel.getGender());
            employee=empRepository.save(employee);
            result="updated succesffully";
        }
        catch (Exception ex){
            result=ex.getMessage();
        }

         return result;
    }

    @Override
    public Optional<Employee> getEmployyeById(int id) {
        Optional<Employee> employee=null;
        try {
            employee= empRepository.findById(id);
        }
        catch (Exception ex){
            //log ex.getmessage();
            System.out.println(ex.getMessage());
        }
        return employee;
    }

    @Override
    public List<TaskInfo> getTaskListByEmpoyee(int id) {
    List<TaskInfo> list=new ArrayList<>();
    try {
        Employee employee=empRepository.getById(id);
        list.add(new TaskInfo("Task1","Task1 desc","Inprogess"));
        list.add(new TaskInfo("Task2","Task2 desc","Started"));
        list.add(new TaskInfo("Task3","Task3 desc","InCompelet"));
        //if we create TaskInfo in database we can map emplotee and TaskInfo by one to many
    }
    catch (Exception ex){

    }
    return list;
    }
}
