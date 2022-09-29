package com.example.demo.controller;

import java.util.List;


import com.example.demo.Repoitories.CustomerRepository;
import com.example.demo.Repoitories.OrdersRepository;
import com.example.demo.entites.Customer;
import com.example.demo.entites.Orders;
import com.example.demo.serviceimplement.CustomerServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	@Autowired
	CustomerServiceImp customerService;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/customer")
	public Customer create(  @RequestBody Customer cus) {
		Customer customer = customerService.create(cus);
		return customer;
	}
	@GetMapping("/customers")
	public List<Customer> listAllCustomers(){
		 List<Customer> lst = customerService.findAll();
		return lst;
		
	}
	// tổng số cho một khách hàng, trả về một Chuỗi với tất cả các đơn đặt hàng cho một id khách hàng nhất định (phương pháp listCustomerOrders)
	
	@GetMapping("/customerOrder")
	public Customer listCustomerOrders(Integer id, Customer cus, @RequestBody  List<Orders> order){
			
		Customer customer =	customerRepository.listCustomerOrders(id, cus,order );
		customer.setCustomerId(id);			
		customer.setOrders(order);
						//cus.setOrders(order);
			return customer;
}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Object> putEntity (@PathVariable(name = "id", required = false) Integer id, @RequestBody Customer cus) {
		cus.setCustomerId(Integer.valueOf(id));
		customerRepository.save(cus);	
		return ResponseEntity.ok(cus);
		
		//ResponseEntity<Object> customer = customerService.update(id, customer);
		//System.out.print(id);
		//System.out.print(cus);
		//return ResponseEntity.ok("jhvjh");
	}
	@DeleteMapping("customer/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id, Customer cus){
		cus.setCustomerId(Integer.valueOf(id));
	customerRepository.delete(cus);
		
		return ResponseEntity.ok().build();
	}
}      
	