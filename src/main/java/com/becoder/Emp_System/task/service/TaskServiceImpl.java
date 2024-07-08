package com.becoder.Emp_System.task.service;

import com.becoder.Emp_System.employee.entity.Employee;
import com.becoder.Emp_System.task.entity.Task;
import com.becoder.Emp_System.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskName(taskDetails.getTaskName());
            task.setDescription(taskDetails.getDescription());
            task.setProject(taskDetails.getProject());
            task.setStatus(taskDetails.getStatus());
            task.setStartDate(taskDetails.getStartDate());
            task.setEndDate(taskDetails.getEndDate());
            task.setAssignedEmployee(taskDetails.getAssignedEmployee());
            task.setEstimatedTime(taskDetails.getEstimatedTime());
            return taskRepository.save(task);
        }
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }

    @Override
//    public Employee getEmployeeByTaskId(Long taskId) {
//        return taskRepository.findAssignedEmployeeByTaskId(taskId);
//
//    }
    public Employee getEmployeeByTaskId(Long taskId) {
        Employee employee = taskRepository.findEmployeeByTaskId(taskId);

        return employee;
    }

//////////////////////////////////////////////////////////

     /*   @Override
        public Task updateTask(Long id, Task taskDetails) {
            Optional<Task> optionalTask = taskRepository.findById(id);
            if (optionalTask.isPresent()) {
                Task task = optionalTask.get();
                // Update task details
                task.setTaskName(taskDetails.getTaskName());
                task.setDescription(taskDetails.getDescription());
                task.setProject(taskDetails.getProject());
                task.setStatus(taskDetails.getStatus());
                task.setStartDate(taskDetails.getStartDate());
                task.setEndDate(taskDetails.getEndDate());
                task.setEstimatedTime(taskDetails.getEstimatedTime());

                // Assign task to employee
                task.setAssignedEmployee(taskDetails.getAssignedEmployee());

                return taskRepository.save(task);
            }
            return null;
        }

}*/
}
