package com.example.demo.Repoitories;

import com.example.demo.entites.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
