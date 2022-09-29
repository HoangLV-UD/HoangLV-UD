package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Product;

import org.springframework.http.ResponseEntity;


public interface ProductService {
	public List<Product> findAll();
	public Product findByName(String ProductName);
	public Product create(Product product);
	//public ResponseEntity<Object> update(String id, Product product);
}
