package com.example.demo.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="LineItem")
public class LineItem {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int LineItemId;
	
	@ManyToMany
	@JoinColumn(name="Orderid")
	List<Orders> Orders;
	
	@ManyToMany
	@JoinColumn(name="Productid")
	List<Product> Product;
	
	@Column(name="quantity")
	private int Quantity;
	
	@Column(name="price")
	@JsonProperty("price")
	private float price;
	
	
	
	
	
	
}
