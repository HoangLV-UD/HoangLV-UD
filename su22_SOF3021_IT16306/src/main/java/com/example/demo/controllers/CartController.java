package com.example.demo.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.CartItem;
import com.example.demo.model.Accounts;
import com.example.demo.model.OrderDetails;
import com.example.demo.model.Orders;
import com.example.demo.model.Products;
import com.example.demo.repositories.OderDetailReponsitory;
import com.example.demo.repositories.OrderReponsitory;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.CartService;

@Controller
@RequestMapping("/admin/cart")
public class CartController {
	@Autowired
	 private ProductRepository proRepo;
	@Autowired
	private OrderReponsitory orderRepo;
	@Autowired
	private OderDetailReponsitory orderDetalRepo;
	@Autowired
	CartService cartServ;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/index")
	public String list(Model model) {
		Collection<CartItem> cartItems = cartServ.getCartItems();
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("total", cartServ.getAmount());
		model.addAttribute("NoOfItems", cartServ.getCount()); //tong so sp
		return "/admin/cart/index";
	}
	
	@GetMapping("/create/{productId}")
	public String Create(@PathVariable("productId") Integer product_id,Accounts accounts) {
		Optional<Products> op =proRepo.findById(product_id);
		Products product = op.get();
		
		if(product != null) {
			
			CartItem item = new CartItem();
			item.setProductId(product.getId());
			
			item.setName(product.getName());
			
			item.setPrice(product.getPrice());
			
			item.setQuantity(1);
			cartServ.add(item);
			System.out.println("Them thanh cong");
		}
		return "redirect:/admin/cart/index";
	}
	@GetMapping("/pay")
	public String Pay(Model model, Orders order, Products product, Accounts account) {
		Collection<CartItem> cartitem = cartServ.getCartItems();
		account = (Accounts) session.getAttribute("accounts");
		//lay ra ten va set dia chi cua  ng dung khi ng dung nhan thanh toan
		order.setUser_id(account);
		order.setAddress("Thanh Hoa");
		//set ngay tao ra order la ngay hien tai 
		Date d = new Date();
		order.setCreate_date(d);
		//tao moi order
		orderRepo.save(order);
		
		for(CartItem cart: cartitem) {
			OrderDetails orderdetail = new OrderDetails();
			orderdetail.setOrder_id(order);
			
			product.setId(cart.getProductId());
			orderdetail.setProduct_id(product);
			
			//mang du lieu
			Optional<Products> optional = proRepo.findById(product.getId());//lay ra id cua sp
			Products product2 = optional.get();//lay tat ca du lieu cua sp 
			Double priceDouble = product2.getPrice();
			orderdetail.setPrice(priceDouble);
			
			orderdetail.setQuantity(cart.getQuantity());
			System.out.println(cart);
			this.orderDetalRepo.save(orderdetail);
		}
		return "redirect:/admin/cart/index";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("productId") Integer productId,@RequestParam("quantity") Integer quantity,Products product) {
		cartServ.update(productId,quantity);
		return "redirect:/admin/cart/index";
	}
	
	@GetMapping("/delete/{productId}")
	public String remove(@PathVariable("productId") Integer productId) {
		cartServ.remove(productId);
		return "redirect:/admin/cart/index";

	}
	
}
