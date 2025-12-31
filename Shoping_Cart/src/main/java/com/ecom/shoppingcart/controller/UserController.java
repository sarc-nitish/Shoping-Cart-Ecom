package com.ecom.shoppingcart.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.shoppingcart.config.CustomUser;
import com.ecom.shoppingcart.model.Cart;
import com.ecom.shoppingcart.model.ProductOrder;
import com.ecom.shoppingcart.model.UserDtls;
import com.ecom.shoppingcart.service.CartService;
import com.ecom.shoppingcart.service.OrderService;
import com.ecom.shoppingcart.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	// ================= USER PROFILE =================
	@GetMapping("/user/profile")
	public String profile(Principal principal, Model model) {

		UserDtls user = userService.getUserByEmail(principal.getName());
		model.addAttribute("user", user);

		return "user/profile";
	}

	// ================= CART =================
	@GetMapping("/user/cart")
	public String cart(Principal principal, Model model) {

		List<Cart> carts = cartService.getCartByUser(principal.getName());
		Double totalOrderPrice = cartService.getTotalPrice(principal.getName());

		model.addAttribute("carts", carts);
		model.addAttribute("totalOrderPrice", totalOrderPrice);

		return "user/cart";
	}

	@GetMapping("/user/addCart")
	public String addToCart(@RequestParam Long pid,
							Principal principal,
							HttpSession session) {

		cartService.addToCart(pid, principal.getName());
		session.setAttribute("succMsg", "Product added to cart");

		return "redirect:/user/cart";
	}

	// ================= ORDER =================
	@GetMapping("/user/orders")
	public String orders(Principal principal, Model model) {

		List<ProductOrder> orders =
				orderService.getOrdersByUser(principal.getName());

		model.addAttribute("orders", orders);
		return "user/my_orders";
	}

	@PostMapping("/user/placeOrder")
	public String placeOrder(Principal principal,
							 HttpSession session) {

		orderService.placeOrder(principal.getName(), null);
		session.setAttribute("succMsg", "Order placed successfully");

		return "redirect:/user/orders";
	}
}
