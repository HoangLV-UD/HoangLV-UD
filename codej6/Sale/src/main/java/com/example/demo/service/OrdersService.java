package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Orders;


public interface OrdersService {
	public List<Orders> findAll();
	public Orders create(Orders orders);
}
