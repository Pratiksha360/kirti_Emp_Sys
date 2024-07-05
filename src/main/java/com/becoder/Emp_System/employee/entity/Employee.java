package com.becoder.Emp_System.employee.entity;

import com.becoder.Emp_System.task.entity.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long id;

    @NotBlank(message = "first name is mandatory")
    @Column(name = "FirstName", length = 50)
    private String firstName;

    @NotBlank(message = "Middle name is mandatory")
    @Column(name = "MiddleName", length = 50)
    private String middleName;

    @NotBlank(message = "Last name is mandatory")
    @Column(name = "LastName", length = 50)
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "Username is mandatory")
    @Column(name = "UserName", unique = true, length = 100)
    private String userName;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Column(name = "Password", length = 255)
    private String password;

    @Size(max = 50, message = "Position must be up to 50 characters")
    @Column(name = "Position", length = 50)
    private String position;

    @Size(max = 255, message = "Profile picture path must be up to 255 characters")
    @Column(name = "ProfilePicture", length = 255)
    private String profilePicture;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits")
    @Column(name = "Contact_No", unique = true, nullable = false, length = 10)
    private String contactNo;

    @Size(max = 255, message = "Address must be up to 255 characters")
    @Column(name = "Address", length = 255)
    private String address;

    @Column(name = "Gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

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
