package com.becoder.Emp_System.task.entity;

import com.becoder.Emp_System.employee.entity.Employee;
import com.becoder.Emp_System.project.entity.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "tasks")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskID")
    private Long id;

    @NotBlank(message = "Task name is mandatory")
    @Column(name = "TaskName", length = 100)
    private String taskName;

    @Size(max = 255, message = "Description must be up to 255 characters")
    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectID" , nullable = false)
    @JsonBackReference("project-tasks")
    private Project project;

    @NotBlank(message = "Status is mandatory")
    @Size(max = 50, message = "Status must be up to 50 characters")
    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EmployeeID")
    private Employee assignedEmployee;

    @Column(name = "EstimatedTime")
    private Long estimatedTime;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt;

    // Constructors, getters, setters, lifecycle methods
}
