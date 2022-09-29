package com.example.demo.serviceimplement;

import java.util.List;

import com.example.demo.Repoitories.ProductRepository;
import com.example.demo.entites.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public Product findByName(String ProductName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product create(Product product) {
		productRepository.save(product);
		return product;
	}

	

}
