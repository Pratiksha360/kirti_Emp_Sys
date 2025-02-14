package com.becoder.Emp_System.project.service;

import com.becoder.Emp_System.project.entity.Project;

import java.util.List;

public interface ProjectService {
    Project saveProject(Project project);
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    Project updateProject(Long id, Project projectDetails);
    void deleteProject(Long id);
}
