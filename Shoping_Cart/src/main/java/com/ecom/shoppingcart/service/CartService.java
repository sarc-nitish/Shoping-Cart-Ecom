package com.ecom.shoppingcart.service;

import java.util.List;

import com.ecom.shoppingcart.model.Cart;

public interface CartService {

	void addToCart(Long productId, String email);

	List<Cart> getCartByUser(String email);

	Double getTotalPrice(String email);

	void updateQuantity(String sy, Long cartId);
}
