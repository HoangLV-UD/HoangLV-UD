package com.example.demo.service;

import java.util.Collection;

import com.example.demo.beans.CartItem;

public interface CartService {

	int getCount();

	Double getAmount();

	void update(int productId, int quantity);

	void clear();

	Collection<CartItem> getCartItems();

	void remove(int productId);

	void add(CartItem item);

}
