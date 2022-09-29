package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.beans.OrderModel;
import com.example.demo.model.Accounts;
import com.example.demo.model.Orders;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.OrderReponsitory;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

	@Autowired
	private OrderReponsitory orepo;
	@Autowired
	private AccountRepository accrepo;

	@GetMapping("/create")
	public String create(@ModelAttribute("order") OrderModel ormodel, Model model) {
		List<Accounts> accounts = this.accrepo.findAll();
		model.addAttribute("acc", accounts);
		return "admin/order/create";

	}

	@PostMapping("/store")
	public String store( @Valid @ModelAttribute("order") Orders order, 
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Orders od = new Orders();
		try {

			od.setUser_id(order.getUser_id());
			od.setCreate_date(order.getCreate_date());
			od.setAddress(order.getAddress());

			this.orepo.save(od);
			session.setAttribute("message", "Thêm mới thành công");
			return "redirect:/admin/order/index";
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("error", "Thêm mới thất bại");
			return "redirect:/admin/order/index";
		}

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Orders order, Model model) {
		List<Accounts> accounts = this.accrepo.findAll();
		model.addAttribute("acc", accounts);

		model.addAttribute("order", order);
		return "admin/order/edit";

	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Orders od, Orders order
			,HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session =request.getSession();	
		od.setUser_id(order.getUser_id());
		od.setCreate_date(order.getCreate_date());
		od.setAddress(order.getAddress());

		this.orepo.save(od);
		session.setAttribute("message", "Sửa thành công");
		return "redirect:/admin/order/index";

	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Orders order,
			HttpServletRequest request, 
			HttpServletResponse response) {
		this.orepo.delete(order);
		HttpSession session =request.getSession();	
		session.setAttribute("message", "Xóa thành công");
		return "redirect:/admin/order/index";
	}

	@GetMapping("/index")
	public String index(@ModelAttribute("order") OrderModel ormodel, Model model,
			@RequestParam(name = "size", defaultValue = "2") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page) {
		List<Accounts> accounts = this.accrepo.findAll();
		model.addAttribute("acc", accounts);
		Pageable pageable = PageRequest.of(page, size);
		Page<Orders> od = this.orepo.findAll(pageable);
		model.addAttribute("data", od);
		return "admin/order/index";

	}
}
