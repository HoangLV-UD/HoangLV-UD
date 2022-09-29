package com.example.demo.Repoitories;

import com.example.demo.entites.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
