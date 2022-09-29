package com.example.demo.beans;

import com.example.demo.model.Orders;
import com.example.demo.model.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {

	private Orders order_id;
	private Products product_id;
	private double price;
	private int quantity;
}
