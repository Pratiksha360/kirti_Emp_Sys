package com.becoder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID")
	private int id;

	@Column(name = "FirstName")
   private String  firstName;
	@Column(name = "MiddleName")
	private String  middleName;
	@Column(name = "LastName")
	private String  lastName;

	@Column(name = "Email")
	private String email;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "Password")
	private String password;

	@Column(name = "Position")
	private String position;

	@Column(name = "ProfilePicture")
	private String profilePicture;

	@Column(name = "Contact_No")
	private String contact_No;
	@Column(name = "Address")
	private String address;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "BirthDate")
	private LocalDateTime birthDate;

	@Column(name = "CreatedAt")
	private LocalDateTime createdAt;

	@Column(name = "UpdatedAt")
	private LocalDateTime updatedAt;

}
