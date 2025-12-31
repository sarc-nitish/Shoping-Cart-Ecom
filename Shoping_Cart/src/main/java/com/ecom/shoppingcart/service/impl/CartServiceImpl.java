package com.ecom.shoppingcart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.shoppingcart.model.Cart;
import com.ecom.shoppingcart.model.Product;
import com.ecom.shoppingcart.model.UserDtls;
import com.ecom.shoppingcart.repository.CartRepository;
import com.ecom.shoppingcart.repository.ProductRepository;
import com.ecom.shoppingcart.repository.UserRepository;
import com.ecom.shoppingcart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;

	public CartServiceImpl(CartRepository cartRepository,
						   ProductRepository productRepository,
						   UserRepository userRepository) {
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void addToCart(Long productId, String email) {

		UserDtls user = userRepository.findByEmail(email);
		Product product = productRepository.findById(productId).orElse(null);

		Cart cart = cartRepository.findByUserAndProduct_Id(user, productId);

		if (cart == null) {
			cart = new Cart();
			cart.setUser(user);
			cart.setProduct(product);
			cart.setQuantity(1);
		} else {
			cart.setQuantity(cart.getQuantity() + 1);
		}
		cart.setTotalPrice(cart.getQuantity() * product.getDiscountPrice());
		cartRepository.save(cart);
	}

	@Override
	public List<Cart> getCartByUser(String email) {
		UserDtls user = userRepository.findByEmail(email);
		return cartRepository.findByUser(user);
	}

	@Override
	public Double getTotalPrice(String email) {
		return getCartByUser(email)
				.stream()
				.mapToDouble(Cart::getTotalPrice)
				.sum();
	}

	@Override
	public void updateQuantity(String sy, Long cartId) {
		Cart cart = cartRepository.findById(cartId).orElse(null);
		if (cart == null) return;

		int qty = cart.getQuantity();
		qty = sy.equals("in") ? qty + 1 : qty - 1;

		if (qty <= 0) {
			cartRepository.delete(cart);
		} else {
			cart.setQuantity(qty);
			cart.setTotalPrice(qty * cart.getProduct().getDiscountPrice());
			cartRepository.save(cart);
		}
	}
}
