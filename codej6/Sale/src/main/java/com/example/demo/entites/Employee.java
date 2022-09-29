package com.example.demo.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@Column(name="Employeeid")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	 private int EmployeeId;
	
	@Column(name="Employeename")
	@JsonProperty("EmployeeName")
	 private String EmployeeName;
	
	@Column(name="Salary")
	@JsonProperty("Salary")
	 private float Salary;
	
	@Column(name="Supervisorid")
	@JsonProperty("SupervisorId")
	 private String SupervisorId;
	 
	@OneToMany(mappedBy ="Employee")
	List<Orders> Orders;
	 

}