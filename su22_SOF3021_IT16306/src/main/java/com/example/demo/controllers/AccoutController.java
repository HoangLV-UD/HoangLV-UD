package com.example.demo.controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

import org.apache.commons.beanutils.BeanUtils;
import com.example.demo.beans.AccountModel;
import com.example.demo.intercepters.mahoa;
import com.example.demo.model.Accounts;
import com.example.demo.repositories.AccountRepository;


@Controller
@RequestMapping("/admin/accounts")
public class AccoutController {
	@Autowired
	private  AccountRepository accountRepo;
	
	@GetMapping("/create")
	public String create(@ModelAttribute("account") AccountModel acc)
	{
		return "admin/accounts/create";
	}  
	
	
	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Accounts account,
			Model model
			) {
		
		model.addAttribute("acc", account);
		
		return "admin/accounts/edit";
		
	}
	@PostMapping("update/{id}")
	public String update(@Valid
			@PathVariable("id") Accounts account,
			HttpServletRequest request,
			AccountModel accmodel 
			) { 
		
			HttpSession session =request.getSession();	
			account.setFullname(accmodel.getFullname());
			account.setUsername(accmodel.getUsername());
			account.setPassword(accmodel.getPassword());
			account.setEmail(accmodel.getEmail());
			account.setPhoto(accmodel.getPhoto());
			account.setAdmin(accmodel.getAdmin());
			account.setActivated(0);
			
			this.accountRepo.save(account);
			session.setAttribute("message", "Sửa thành công");
			return "redirect:/admin/accounts/index";
		
	}

	@PostMapping("/store")
	public String store( @Valid @ModelAttribute("account") AccountModel accModel,
						HttpServletRequest request, 
						HttpServletResponse response)
	{
		Accounts acc = new Accounts();
		HttpSession session =request.getSession();	
		
		try {
			acc.setFullname(accModel.getFullname());
			acc.setUsername(accModel.getUsername());
			acc.setEmail(accModel.getEmail());	
			acc.setPassword(accModel.getPassword());
			acc.setPhoto(accModel.getPhoto());
			acc.setAdmin(accModel.getAdmin());
			
			BeanUtils.populate(acc, request.getParameterMap());
			String encrypted = mahoa.hash(
					request.getParameter("password")
				);
				acc.setPassword(encrypted);
				
				this.accountRepo.save(acc);
			session.setAttribute("message", "Thêm mới thành công");
			return "redirect:/admin/accounts/index";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//thông báo lỗi
			session.setAttribute("error", "Thêm mới thất bại");
			return "admin/accounts/create";
		}
		
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Accounts account,
			HttpServletRequest request)
	{
		HttpSession session =request.getSession();	
		try {
			this.accountRepo.delete(account);
		session.setAttribute("message", "Xóa thành công");
		
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("message", "Xóa thất bại");
		}
		
		return "redirect:/admin/accounts/index";
	}
		
	@GetMapping("index")
	public String index(@ModelAttribute("account") AccountModel acc,	
						Model model,
						@RequestParam(name="size", defaultValue="2") Integer size,
						@RequestParam(name="page", defaultValue="0") Integer page,
						HttpServletRequest request, HttpServletResponse response
						)throws ServletException, IOException {
		
		 
		Pageable pageable = PageRequest.of(page, size);
		Page<Accounts> p = this.accountRepo.findAll(pageable);
		model.addAttribute("data", p);

		
		return "admin/accounts/index";
	}
}
