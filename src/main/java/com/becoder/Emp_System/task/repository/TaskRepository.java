package com.becoder.Emp_System.task.repository;

import com.becoder.Emp_System.employee.entity.Employee;
import com.becoder.Emp_System.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t.assignedEmployee FROM Task t WHERE t.id = :taskId")
    Employee findEmployeeByTaskId(@Param("taskId") Long taskId);
}