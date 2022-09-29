package com.example.demo.controllers.admin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
	
import com.example.demo.beans.User;

@Controller
@RequestMapping("/admin/users")
public class UserController {
	@GetMapping("create")
	public String create(@ModelAttribute("user") User user) {
		return "admin/users/create";
	}
	@PostMapping("store")
	public String store( @Valid @ModelAttribute("user") User user,
			BindingResult result) {
			if(result.hasErrors()) {
				System.out.println("Form kh hop le");
			}else {
				System.out.println("Form hop le");
			}
			
		return "admin/users/create";
	}

}