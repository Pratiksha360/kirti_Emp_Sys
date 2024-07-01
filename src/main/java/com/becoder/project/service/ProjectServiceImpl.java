package com.becoder.project.service;

import com.becoder.project.entity.Project;
import com.becoder.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> saveProject(Project project) {
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        Optional< Project> save = Optional.of(projectRepository.save(project));
        return save;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Override
    public boolean deleteProject(Long projectId) {
        if (projectRepository.existsById(projectId))
        {
            projectRepository.deleteById(projectId);
            return true;
        }
        else{
            return false;
        }
    }
}
