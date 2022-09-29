package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.beans.User;

@Controller
//@Controller đánh dấu class là của controller do IoC Controller quản lý và nó phải gọi qua thằng @autowwire
//đánh dấu class này là một spring beans và được quản lý bởi IoContainer
//@RequestMapping("/admin/users")
//Nếu như khai báo RequestMapping ở đầu thì tất cả các hàm bên dưới đều có tiền tố là /admin/users 
public class helloController {
	@Autowired
		private User user;
	
		//ánh xạ đường dẫn và các phương thức bên trong controller
		//cách 1 để sử dụng mỗi method get thôi  value = "/hello",method = RequestMethod.GET     
		//cách 2: @GetMapping("hello")
		@GetMapping("hello")
	
		
	
	public String hello(
							Model model,
							@RequestParam(name="ho_ten",
							defaultValue="IT16306"
							) String hoTen
						) {
			System.out.println("helloController@hello");	
					model.addAttribute("message", hoTen);
					return "hello";
				}
		@GetMapping("demo-bean")
		@ResponseBody
		public String demoBean() {
			user.setHoTen("j z cha nọi");
			return "Hello, "+ this.user.getHoTen();
		}
}
