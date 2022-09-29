package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderDetails;

public interface OderDetailReponsitory extends JpaRepository<OrderDetails, Integer> {

}
