package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(int id);


}
