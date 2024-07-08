package com.becoder.Emp_System.project.entity;

import com.becoder.Emp_System.task.entity.Task;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectID")
    private Long id;

    @NotBlank(message = "Project name is mandatory")
    @Size(max = 100, message = "Project name must be up to 100 characters")
    @Column(name = "ProjectName", length = 100)
    private String projectName;

    @Size(max = 255, message = "Description must be up to 255 characters")
    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @NotBlank(message = "Status is mandatory")
    @Size(max = 50, message = "Status must be up to 50 characters")
    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("project-tasks")
    private List<Task> tasks;

    // Getters and setters

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
