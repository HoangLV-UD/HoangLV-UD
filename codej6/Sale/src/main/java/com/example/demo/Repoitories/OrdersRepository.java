package com.example.demo.Repoitories;

import com.example.demo.entites.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}