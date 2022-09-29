package com.example.demo.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
@Table(name="Product")
public class Product {
	@Id
	@Column(name="Productid")
	@JsonProperty("ProductId")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int  ProductId;
	
	@JsonProperty("ProductName")
	@Column(name="Productname")
	private String ProductName;
	
	@JsonProperty("ListPrice")
	@Column(name="Listprice")
	private float Listprice;
	
	@ManyToMany(mappedBy = "Product")
//	@JoinTable(name = "line_item_product", 
//			joinColumns = @JoinColumn(name ="product_id"),
//			inverseJoinColumns =  @JoinColumn(name = "line_item_id"))
	List<LineItem> LineItem;
	
	
}
