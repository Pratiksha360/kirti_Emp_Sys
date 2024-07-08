package com.becoder.Emp_System.employee.controller;

import com.becoder.Emp_System.employee.service.EmployeeService;
import com.becoder.Emp_System.employee.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createemployee")          // localhost:8080/employee/createemployee
    public ResponseEntity<?> createEmployee(@RequestBody @Valid  Employee employee) {
        try {
            Employee createdEmployee = employeeService.saveEmployee(employee);
            return ResponseEntity.ok(createdEmployee);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate field value: " + ex.getMostSpecificCause().getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/getallemployee")                       //localhost:8080/employee/getallemployee
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getemployeebyid/{id}")              //localhost:8080/employee/getemployeebyid/5
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.getEmployeeById(id));
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateemployeebyid/{id}")                            //localhost:8080/employee/updateemployeebyid/5
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/deleteemployeebyid/{id}")                 //localhost:8080/employee/deleteemployeebyid/6
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
