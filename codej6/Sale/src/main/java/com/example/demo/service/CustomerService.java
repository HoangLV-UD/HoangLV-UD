package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Customer;

import org.springframework.http.ResponseEntity;

public interface CustomerService {
	public List<Customer> findAll();
	public Customer findByName(String customerName);
	public Customer create(Customer customer);
	public ResponseEntity<Object> update(String id, Customer customer);
	
	
}
