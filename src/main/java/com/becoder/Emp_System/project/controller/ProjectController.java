package com.becoder.Emp_System.project.controller;

import com.becoder.Emp_System.project.entity.Project;
import com.becoder.Emp_System.project.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/createproject")                       //localhost:8080/project/createproject
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        Project createdProject = projectService.saveProject(project);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/getallproject")                              //localhost:8080/project/getallproject
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }


    @GetMapping("/getprojectbyid/{id}")                        //localhost:8080/project/getprojectbyid/3
    public ResponseEntity<Project> getTaskById(@PathVariable Long id) {
        Optional<Project> project= Optional.ofNullable(projectService.getProjectById(id));
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateprojectbyid/{id}")                //localhost:8080/project/updateprojectbyid/3
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @Valid @RequestBody Project projectDetails) {
        Project updatedProject = projectService.updateProject(id, projectDetails);
        if (updatedProject == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/deleteprojectbyid/{id}")                //localhost:8080/project/deleteprojectbyid/2
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}

