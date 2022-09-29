package com.example.demo.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Categories;
import com.example.demo.model.Products;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/index")
	public String index(Model model,  @RequestParam(name = "size", defaultValue = "3") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page) {
		
		Categories category = new Categories();
		List<Categories> lstCategories = categoryRepo.findAll(); 
		model.addAttribute("lstCategories", lstCategories);
		model.addAttribute("category", category);
		
		Products product = new Products();
		model.addAttribute("product", product);
		List<Products> lstProduct = productRepo.findAll();
		model.addAttribute("listpro", lstProduct);

		Pageable pageable = PageRequest.of(page, size);
		Page<Products> p = this.productRepo.findAll(pageable); 
		model.addAttribute("data", p);
		return "/admin/main";
	}
}
