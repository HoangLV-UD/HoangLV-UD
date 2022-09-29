package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
