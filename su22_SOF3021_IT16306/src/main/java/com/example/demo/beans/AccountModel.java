package com.example.demo.beans;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AccountModel {
	
	@NotBlank(message="Khong duoc de trong User Name")
	private String username; 
	
	@NotBlank(message="Khong duoc de trong Password")
	@Length(min=3, message="Mat khau tren 3 ki tu")
	private String password;
	
	@NotBlank(message="Khong duoc de trong Full Name")
	private String fullname;
	
	@NotBlank(message = "Khong duoc de trong email")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Sai dinh dang email")
	private String email;
	
	@NotBlank(message = "Không được rỗng")	
	private String photo;
	
	private int activated;
	private int admin;
}