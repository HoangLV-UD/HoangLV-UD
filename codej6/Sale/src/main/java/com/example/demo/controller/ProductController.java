package com.example.demo.controller;

import java.util.List;

import com.example.demo.Repoitories.ProductRepository;
import com.example.demo.entites.Product;
import com.example.demo.serviceimplement.ProductServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductServiceImp productServiceImp;

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getAll(){
		List<Product> lstList = productRepository.findAll(); 
		//System.out.println(lstList);
		return lstList;
	}
	
	@PostMapping("/product")
	public Product create( @RequestBody Product pro) {
		//Product product = productServiceImp.create(pro);
		productRepository.save(pro);
		return pro;
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updatEntity(@PathVariable(name = "id", required = false) Integer id, @RequestBody Product pro){
		pro.setProductId(id);
		productRepository.save(pro);
		return ResponseEntity.ok(pro);
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deletEntity (@PathVariable(name = "id")Integer id, Product pro ){
		pro.setProductId(id);
		productRepository.delete(pro);
		return ResponseEntity.ok().build();
	}
}
