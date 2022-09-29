package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.ProductModel;
import com.example.demo.model.Categories;
import com.example.demo.model.Products;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/product")
public class ProuctController {
	@Autowired
	private ProductRepository proRepo;
	@Autowired
	private CategoryRepository cateRepo;
	
	

	@GetMapping("/create")
	public String create(Model model, @ModelAttribute("product") ProductModel pro) {
		List<Categories> lst = this.cateRepo.findAll();
		System.out.println(lst);
		model.addAttribute("cate", lst);
		return "admin/product/create";
	}

	@PostMapping("/store")
	public String store( Model model, @Valid @ModelAttribute("product")
			ProductModel proModel)
	{
			Products pro = new Products();
			pro.setName(proModel.getName());
			pro.setPrice(proModel.getPrice());
			pro.setImage(proModel.getImage());
			pro.setCreated_date(proModel.getCreated_date());
			
			pro.setCategory_id(proModel.getCategory_id());
			pro.setAvailable(proModel.getAvailable());
			
			this.proRepo.save(pro);
			return "redirect:/admin/product/index";
		
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Products pro, Model model) {
		List<Categories> listcate = this.cateRepo.findAll();
		model.addAttribute("cate", listcate);

		model.addAttribute("product", pro);
		return "admin/product/edit";
	}

	@PostMapping("update/{id}")
	public String update(
			@PathVariable("id") Products product, Products promodel) {

		product.setName(promodel.getName());
		product.setImage(promodel.getImage());
		product.setPrice(promodel.getPrice());
		product.setCreated_date(promodel.getCreated_date());
		product.setAvailable(promodel.getAvailable());
		product.setCategory_id(promodel.getCategory_id());

		this.proRepo.save(product);

		return "redirect:/admin/product/index";

	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Products product) {
		this.proRepo.delete(product);

		return "redirect:/admin/product/index";
	}

	@GetMapping("/index")
	public String index(Model model, @ModelAttribute("product") ProductModel pro,
			@RequestParam(name = "size", defaultValue = "2") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page) {
		List<Categories> lst = this.cateRepo.findAll();
		System.out.println(lst);
		model.addAttribute("cate", lst);
		Pageable pageable = PageRequest.of(page, size);
		Page<Products> prod = this.proRepo.findAll(pageable);
		model.addAttribute("data", prod);
		return "admin/product/index";

	}
}
