package com.example.demo.entites;

import java.util.List;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.helper.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Orders")
public class Orders {
	@Id
	@Column(name="Orderid")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int OrderId;
	
	@Column(name="Total")
	private int total;
	
	@Column(name="Orderdate")
	@JsonProperty("orerdate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY:MM:DD HH:MM:SS", timezone = DateUtils.MY_TIME_ZONE)
	private Date OrderDate;
	
	@ManyToOne
	@JoinColumn(name="Customerid")
	//@JsonProperty("customerid")
	Customer Customer;
	
	@ManyToOne
	@JoinColumn(name="Employeeid")
	//@JsonProperty("employeeid")
	Employee Employee;
	
	@ManyToMany(mappedBy ="Orders")
	List<LineItem> LineItem;
	
	
	
}
