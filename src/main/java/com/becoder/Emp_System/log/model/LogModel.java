package com.becoder.Emp_System.log.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogModel {
   private Long employeeID;
    private LocalDate logDate;

    private LocalDateTime logInTime;

    private LocalDateTime logOutTime;


}
