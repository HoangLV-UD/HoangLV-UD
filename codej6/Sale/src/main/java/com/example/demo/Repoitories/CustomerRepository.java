package com.example.demo.Repoitories;

import java.util.List;

import com.example.demo.entites.Customer;
import com.example.demo.entites.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	
	
//	@Query("select c from Customer c where CustomerId = ?1")
//	Customer findById(Customer customerid);
	
	@Query(value = "select orders.orderid, customer.customername, orders.total\r\n"
			+ "  from orders inner join customer\r\n"
			+ "  on orders.customerid = customer.customerid\r\n"
			+ "  where customer.customerid =  ?1", nativeQuery = true)
	Customer listCustomerOrders(Integer id, Customer customerId, List<Orders> order);

}
