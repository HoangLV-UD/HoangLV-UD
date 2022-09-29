package com.example.demo.serviceimplement;

import java.util.List;

import com.example.demo.Repoitories.EmployeeRepository;
import com.example.demo.entites.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findByName(String EmployeeName) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Employee creat(Employee employee) {
//		employeeRepository.save(employee);
//		return employee;
//	}

}
