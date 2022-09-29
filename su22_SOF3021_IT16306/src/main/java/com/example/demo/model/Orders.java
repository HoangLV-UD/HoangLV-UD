package com.example.demo.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Accounts user_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column (name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date  create_date ;
	
	@Column (name = "address")
	private String address;
	

}
