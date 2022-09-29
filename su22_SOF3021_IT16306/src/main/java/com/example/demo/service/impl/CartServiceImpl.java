package com.example.demo.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.beans.CartItem;
import com.example.demo.service.CartService;

@Service
@SessionScope
public class CartServiceImpl implements CartService {
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	@Override
	public void add(CartItem item) {
		CartItem exitstedItem= map.get(item.getProductId());
		
		if (exitstedItem !=null) {
			exitstedItem.setQuantity(item.getQuantity()+exitstedItem.getQuantity());
		} else {
			map.put(item.getProductId(), item);
		}
		
	}
	@Override
	public void remove(int productId) {
		map.remove(productId);
	}
	@Override
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	@Override
	public void clear() {
		 map.clear();
	}
	@Override
	public void update(int productId,int quantity) {
		CartItem item=map.get(productId);
		
		item.setQuantity(quantity);
		if (item.getQuantity() <=0) {
			map.remove(productId);
			
		}
	}
	@Override
	public Double getAmount() {
		return map.values().stream().mapToDouble(item->item.getQuantity() * item.getPrice()).sum();
	}
	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}
}
