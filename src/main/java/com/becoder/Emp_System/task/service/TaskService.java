package com.becoder.Emp_System.task.service;

import com.becoder.Emp_System.employee.entity.Employee;
import com.becoder.Emp_System.task.entity.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTask(Long id, Task taskDetails);
    void deleteTask(Long id);

    Employee getEmployeeByTaskId(Long taskId);
}
