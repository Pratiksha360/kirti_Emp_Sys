package com.becoder.project.service;

import com.becoder.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Optional<Project>saveProject(Project project);

    List<Project> getAllProjects();

    Optional<Project> getProjectById(Long projectId);

    boolean deleteProject(Long projectId);
}
