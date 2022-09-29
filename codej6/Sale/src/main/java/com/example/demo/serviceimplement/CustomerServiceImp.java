package com.example.demo.serviceimplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.Repoitories.CustomerRepository;
import com.example.demo.entites.Customer;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findByName(String customerName) {
		return customerRepository.findById(customerName).get();
	}

	@Override
	public Customer create(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public ResponseEntity<Object> update(String id,Customer customer) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if(customerOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		 
		customer.setCustomerId(Integer.valueOf(id));
			customerRepository.save(customer);
		return ResponseEntity.noContent().build();
	}
	
	
}
