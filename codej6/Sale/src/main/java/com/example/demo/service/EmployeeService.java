package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findByName(String EmployeeName);
	//public Employee creat(Employee employee);
}
