package com.example.demo.beans;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CategoryModel {
	@NotBlank(message = "Khong duoc de trong")
	@Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Sau cu phap")
	private String name;
}
