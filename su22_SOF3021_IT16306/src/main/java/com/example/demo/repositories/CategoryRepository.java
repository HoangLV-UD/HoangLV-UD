package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
