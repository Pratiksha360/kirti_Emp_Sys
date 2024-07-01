package com.becoder.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeUpdateModel {


    private int id;

    private String  firstName;
    private String  middleName;
    private String  lastName;
    private String userName;
    private String password;
    private String profilePicture;
    private String contact_No;
    private String address;
    private String gender;
    private LocalDateTime birthDate;
    private LocalDateTime updatedAt;

}
