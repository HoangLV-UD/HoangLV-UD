package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.beans.OrderDetailModel;
import com.example.demo.model.OrderDetails;
import com.example.demo.model.Orders;
import com.example.demo.model.Products;
import com.example.demo.repositories.OderDetailReponsitory;
import com.example.demo.repositories.OrderReponsitory;
import com.example.demo.repositories.ProductRepository;





@Controller
@RequestMapping("/admin/orderdetail")
public class OrderDetailController {
	@Autowired
	private OderDetailReponsitory tailrepo;
	@Autowired
	private ProductRepository prorepo;
	@Autowired
	private OrderReponsitory orrpo;

	@GetMapping("/create")
	public String create(@ModelAttribute("orderdetail") OrderDetailModel orModel, Model model) {
		
		List<Orders> od = this.orrpo.findAll();
		model.addAttribute("oder", od);

		List<Products> products = this.prorepo.findAll();
		model.addAttribute("product", products);

		return "admin/orderdetail/create";

	}

	@PostMapping("/store")
	public String store(OrderDetails ord) {
		OrderDetails odtDetail = new OrderDetails();
		odtDetail.setOrder_id(ord.getOrder_id());
		odtDetail.setProduct_id(ord.getProduct_id());
		odtDetail.setPrice(ord.getPrice());
		odtDetail.setQuantity(ord.getQuantity());

		this.tailrepo.save(odtDetail);

		return "redirect:/admin/orderdetail/index";
		
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") OrderDetails orderDetail) {
		List<Orders> order = this.orrpo.findAll();
		List<Products> product = this.prorepo.findAll();
		model.addAttribute("dsO",order);
		model.addAttribute("dsPro", product);
		model.addAttribute("orderDetail", orderDetail);
		return "admin/orderdetail/edit";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") OrderDetails orderDetail, 
			OrderDetails order) {

		orderDetail.setOrder_id(order.getOrder_id());
		orderDetail.setProduct_id(order.getProduct_id());
		orderDetail.setPrice(order.getPrice());
		orderDetail.setQuantity(order.getQuantity());

		this.tailrepo.save(orderDetail);

		return "redirect:/admin/orderdetail/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") OrderDetails ord) {

		this.tailrepo.delete(ord);

		return "redirect:/admin/orderdetail/index";

	}

	@GetMapping("/index")
	public String index(@ModelAttribute("orderdetail") OrderDetailModel orModel,
			Model model,
			@RequestParam(name = "size", defaultValue="2") Integer size,
			@RequestParam(name = "page", defaultValue="0") Integer page
			) {
		List<Orders> od = this.orrpo.findAll();
		model.addAttribute("oder", od);

		List<Products> products = this.prorepo.findAll();
		model.addAttribute("product", products);
		Pageable pageable = PageRequest.of(page, size);
		Page<OrderDetails> ord = this.tailrepo.findAll(pageable);
		model.addAttribute("data", ord);
		return "admin/orderdetail/index";
	}
}
