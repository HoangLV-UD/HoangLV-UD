package com.example.demo.serviceimplement;

import java.util.List;

import com.example.demo.Repoitories.OrdersRepository;
import com.example.demo.entites.Orders;
import com.example.demo.service.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;

public class OrdersServiceImp implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return ordersRepository.findAll();
	}

	@Override
	public Orders create(Orders orders) {
		ordersRepository.save(orders);
		return orders;
	}

}
