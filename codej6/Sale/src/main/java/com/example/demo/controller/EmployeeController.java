package com.example.demo.controller;

import java.util.List;

import com.example.demo.Repoitories.EmployeeRepository;
import com.example.demo.entites.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employee")
	public Employee creat(@RequestBody Employee empl) {
		Employee employee = employeeRepository.save(empl);
		return employee;
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> entity(@PathVariable(name = "id", required = false) Integer id,
			@RequestBody Employee employee) {
		employee.setEmployeeId(id);
		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> delete(@PathVariable (name = "id") Integer id, Employee empl){
		empl.setEmployeeId(id);
		employeeRepository.delete(empl);
		return ResponseEntity.ok().build();
	
	
	}
}
