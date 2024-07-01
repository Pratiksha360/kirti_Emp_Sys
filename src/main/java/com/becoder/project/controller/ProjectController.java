package com.becoder.project.controller;

import com.becoder.project.entity.Project;
import com.becoder.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/addproject")
    public Optional<Project> addProject(@RequestBody Project project) {

        Optional<Project> pro = projectService.saveProject(project);
      return pro;
    }

  @GetMapping("/allproject")
  public ResponseEntity<List<Project>> getAllProjects() {
      List<Project> projects = projectService.getAllProjects();
      return new ResponseEntity<>(projects, HttpStatus.OK);
  }

    @GetMapping("/getprojectbyid/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long projectId) {
        Optional<Project> project = projectService.getProjectById(projectId);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteprojectbyid/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable("id") Long projectId) {
        if (projectService.deleteProject(projectId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
