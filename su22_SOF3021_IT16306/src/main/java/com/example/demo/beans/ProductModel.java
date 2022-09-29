package com.example.demo.beans;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.example.demo.model.Categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductModel {
	@NotBlank(message="Không được để trống")
	private String name;
	private String image;
	
	@NotNull(message = "Không được rỗng ngày")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "Nhap ngay hien tai hoac qua khu")
	@Temporal(TemporalType.DATE)
	private Date created_date;
	
//	@NotNull(message="Không để trống giá")
//	@NegativeOrZero(message="Nhập giá trên 0")
	private int price; 
	
	private int available;	
	private Categories category_id;
}
