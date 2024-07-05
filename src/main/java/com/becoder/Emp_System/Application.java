package com.becoder.Emp_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.becoder.Emp_System")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
