package com.becoder.Emp_System.log.entity;

import com.becoder.Emp_System.employee.entity.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID")
    private Long logID;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EmployeeID")
    @JsonBackReference("employee-logs")
    private Employee employee;

    @Column(name = "LogDate")
    private LocalDate logDate;

    @Column(name = "LogInTime")
    private LocalDateTime logInTime;

    @Column(name = "LogOutTime")
    private LocalDateTime logOutTime;

    //no need to getter setter
}


