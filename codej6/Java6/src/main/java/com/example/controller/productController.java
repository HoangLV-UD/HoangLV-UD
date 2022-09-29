package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class productController {
	@RequestMapping("/product/list")
	
	public String list() {
		return "product/list"; 
	}
}
