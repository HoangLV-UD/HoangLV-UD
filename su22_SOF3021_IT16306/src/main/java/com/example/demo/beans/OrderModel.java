package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.example.demo.model.Accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OrderModel{
	
	private Accounts user_id;
	
	@NotNull(message = "Không được để trống ngày")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date create_date;
	@NotBlank(message = "Khong Duoc De Trong Dia Chi")
	private String address;
}
