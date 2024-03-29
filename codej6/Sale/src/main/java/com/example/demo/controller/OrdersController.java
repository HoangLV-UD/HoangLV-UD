package com.example.demo.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.example.demo.Repoitories.OrdersRepository;
import com.example.demo.entites.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.Parser;



@RestController
public class OrdersController {

	@Autowired
	OrdersRepository ordersRepository;
	
	
	
//	@GetMapping("/orders")
//	public List<Orders> getAll(){
//		List<Orders> lstList = ordersRepository.findAll();	
//		//JSONParser jsonParser = JSONParser. //is not working
//		return lstList;
//	}
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAll(){
		List<Orders> lstList = ordersRepository.findAll();
		return ResponseEntity.ok().body(lstList); //is not working
	}
//	public Date Date(String date) {
//		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
//		Date date = 
//	    return formatter.format(date);  
//	}
	@GetMapping("/order/{id}") // is work :) but it not get orderdate
	public Orders getbyId(@PathVariable (name = "id") Integer id, Orders o ) {
		Orders orders = o;
		o = ordersRepository.findById(id).get();
//		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
//		try {
//			Date date =  formatter.parse(o.getOrderDate());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		//Date date = o.getOrderDate();

//		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");x
//	is not working
//		String dateString  = df.format(date);
		
		
//      try {
//    	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Date date = (Date) df.parse("01-01-1970 01:00");
//       
//		Event event = new Event("party", 0, date);
//        ObjectMapper mapper = new ObjectMapper();// is not working
//		String json = mapper.writeValueAsString(event);
//	} catch (JsonProcessingException e) {
//		e.printStackTrace();
//	}
	
		orders.setCustomer(o.getCustomer());
		orders.setEmployee(o.getEmployee());
		orders.setOrderDate(o.getOrderDate());
		// orders.setOrderDate(Date(new Date(o)));
		orders.setTotal(o.getTotal());
		//o.setOrderId(id);
		
		//ordersRepository.getById(String.valueOf(o));
		return orders;
	}
//	@PostMapping("/order")
//	public Orders create(@RequestBody Orders or) {
//		Orders orders = ordersRepository.save(or);
//		orders.setCustomer(or.getCustomer());
//		orders.setEmployee(or.getEmployee());
//		orders.setTotal(or.getTotal());  //not working
//		orders.setOrderDate(or.getOrderDate());
//		return orders;
//	}
	
	@PostMapping("/order")
	public ResponseEntity<Orders> create(@RequestBody Orders orders ){
		Orders orders2 = ordersRepository.save(orders);// is not working,  but it just insert field total
		return ResponseEntity.ok(orders2);
	}
	
	@PutMapping("/order/{id}")
	public ResponseEntity<Orders> update(@PathVariable(name = "id", required = false)  Integer id, @RequestBody Orders or){
		or.setOrderId(id);
		ordersRepository.save(or);
		return ResponseEntity.ok(or);
	}
	@DeleteMapping("/order/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id, Orders or ){
		or.setOrderId(id);
		ordersRepository.delete(or);
		return ResponseEntity.ok().build();
	}
}
