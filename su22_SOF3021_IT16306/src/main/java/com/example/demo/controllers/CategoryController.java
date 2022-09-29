package com.example.demo.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.CategoryModel;
import com.example.demo.model.Categories;
import com.example.demo.repositories.CategoryRepository;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/create")
	public String create(@ModelAttribute("category") CategoryModel cate)
	{
		return "admin/category/create";
	}   
	
	@PostMapping("/store")
	public String store( @Valid @ModelAttribute("category") CategoryModel cateModel,
			BindingResult result)
	{
		Categories categ = new Categories();
		
		if(result.hasErrors()) {
			
			return"admin/category/create";
		} else{
			categ.setName(cateModel.getName());
			this.categoryRepo.save(categ);
			return "redirect:/admin/category/index";
		}
		
		
	}
	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Categories cate,
			Model model
			) {
		
		model.addAttribute("cate", cate);
		return "admin/category/edit";
		
	}

	@PostMapping("update/{id}")
	public String update(
			@PathVariable("id") Categories cate,
			CategoryModel catemodel,
			HttpServletRequest request
			) {
		HttpSession session =request.getSession();	
		cate.setName(catemodel.getName());
		
		this.categoryRepo.save(cate);
		session.setAttribute("message", "Sửa thành công");
		return "redirect:/admin/category/index";
		
		
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Categories cate,
						HttpServletRequest request) {
		HttpSession session =request.getSession();	
		try {
			this.categoryRepo.delete(cate);
			session.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("message", "Xóa thát bại");
		}
			
			
			return "redirect:/admin/category/index";
	}
	
	@GetMapping("index")
	public String index(@ModelAttribute("category") CategoryModel cate,
		Model model,
		@RequestParam(name="size", defaultValue="2") Integer size,
		@RequestParam(name="page", defaultValue="0") Integer page
	) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Categories> p = this.categoryRepo.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/category/index";
	}
}
