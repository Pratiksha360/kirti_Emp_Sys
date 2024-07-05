package com.becoder.Emp_System.task.controller;

import com.becoder.Emp_System.task.entity.Task;
import com.becoder.Emp_System.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/createtask")                                   //localhost:8080/task/createtask
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/getalltask")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/gettaskbyid/{id}")                                 //localhost:8080/task/gettaskbyid/1
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = Optional.ofNullable(taskService.getTaskById(id));
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updatetask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("deletetaskbyid/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

