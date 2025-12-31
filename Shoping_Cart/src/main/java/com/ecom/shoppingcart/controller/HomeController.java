package com.ecom.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecom.shoppingcart.model.Category;
import com.ecom.shoppingcart.model.Product;
import com.ecom.shoppingcart.service.CategoryService;
import com.ecom.shoppingcart.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index(Model model) {

		List<Category> categories =
				categoryService.getAllActiveCategory();

		List<Product> products =
				productService.getLatestProducts();

		model.addAttribute("categories", categories);
		model.addAttribute("products", products);

		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
