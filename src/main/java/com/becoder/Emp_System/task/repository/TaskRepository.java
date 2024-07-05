package com.becoder.Emp_System.task.repository;

import com.becoder.Emp_System.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
