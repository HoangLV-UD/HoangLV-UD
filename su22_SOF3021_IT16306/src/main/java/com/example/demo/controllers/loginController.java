package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.intercepters.mahoa;
import com.example.demo.model.Accounts;
import com.example.demo.repositories.AccountRepository;

@Controller
public class loginController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("/login")
	public String getLoginForm() {
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password
	) {
		Accounts entity = this.accountRepo.findByEmail(email);
		HttpSession session = request.getSession();
		if (entity == null) {
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			System.out.println("sai");
			return "/login";
		}

		boolean checkPwd = mahoa.verify(password, entity.getPassword());
		if (!checkPwd) {
			session.setAttribute("error", "Sai mật khẩu");
			System.out.println("sai");
			return "/login";
		}
		
		session.setAttribute("accounts", entity);
		return "redirect:/home/index";
	}
}