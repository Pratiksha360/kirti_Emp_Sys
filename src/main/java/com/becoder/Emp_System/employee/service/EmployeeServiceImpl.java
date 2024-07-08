package com.becoder.Emp_System.employee.service;

import com.becoder.Emp_System.employee.repository.EmployeeRepository;
import com.becoder.Emp_System.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setMiddleName(employeeDetails.getMiddleName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setUserName(employeeDetails.getUserName());
            employee.setPassword(employeeDetails.getPassword());
           // employee.setPosition(employeeDetails.getPosition());
            employee.setProfilePicture(employeeDetails.getProfilePicture());
            employee.setContactNo(employeeDetails.getContactNo());
            employee.setAddress(employeeDetails.getAddress());
            employee.setGender(employeeDetails.getGender());
            employee.setBirthDate(employeeDetails.getBirthDate());
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

   /* @Override
    public Employee getEmployeeByTaskId(Long taskId) {
        return  employeeRepository.findEmployeeByTaskId(taskId);

    }*/
}
