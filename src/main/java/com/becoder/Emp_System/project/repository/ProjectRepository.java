package com.becoder.Emp_System.project.repository;

import com.becoder.Emp_System.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
