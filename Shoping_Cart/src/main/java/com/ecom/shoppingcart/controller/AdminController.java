package com.ecom.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.shoppingcart.model.Category;
import com.ecom.shoppingcart.model.Product;
import com.ecom.shoppingcart.model.ProductOrder;
import com.ecom.shoppingcart.model.UserDtls;
import com.ecom.shoppingcart.service.CategoryService;
import com.ecom.shoppingcart.service.ProductService;
import com.ecom.shoppingcart.service.UserService;
import com.ecom.shoppingcart.service.OrderService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public String adminHome() {
		return "admin/index";
	}

	@GetMapping("/users")
	public String users(Model model) {
		List<UserDtls> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin/users";
	}

	@GetMapping("/products")
	public String products(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "admin/products";
	}

	@GetMapping("/category")
	public String category(Model model) {
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories", categories);
		return "admin/category";
	}

	@GetMapping("/orders")
	public String orders(Model model) {
		List<ProductOrder> orders = orderService.getAllOrders();
		model.addAttribute("orders", orders);
		return "admin/orders";
	}
}
