package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Orders;

public interface OrderReponsitory extends JpaRepository<Orders, Integer> {

}
