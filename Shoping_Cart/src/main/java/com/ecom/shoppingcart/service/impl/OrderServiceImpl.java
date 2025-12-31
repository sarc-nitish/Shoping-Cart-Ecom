package com.ecom.shoppingcart.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecom.shoppingcart.model.*;
import com.ecom.shoppingcart.repository.*;
import com.ecom.shoppingcart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final ProductOrderRepository orderRepository;
	private final UserRepository userRepository;
	private final CartRepository cartRepository;

	public OrderServiceImpl(ProductOrderRepository orderRepository,
							UserRepository userRepository,
							CartRepository cartRepository) {
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.cartRepository = cartRepository;
	}

	@Override
	public void placeOrder(String email, Object request) {

		UserDtls user = userRepository.findByEmail(email);
		List<Cart> carts = cartRepository.findByUser(user);

		for (Cart c : carts) {
			ProductOrder order = new ProductOrder();
			order.setOrderId(UUID.randomUUID().toString());
			order.setOrderDate(LocalDate.now());
			order.setUser(user);
			order.setProduct(c.getProduct());
			order.setQuantity(c.getQuantity());
			order.setPrice(c.getProduct().getDiscountPrice());
			order.setStatus(OrderStatus.ORDERED);
			orderRepository.save(order);
		}
		cartRepository.deleteAll(carts);
	}

	@Override
	public List<ProductOrder> getOrdersByUser(String email) {
		UserDtls user = userRepository.findByEmail(email);
		return orderRepository.findByUser(user);
	}

	@Override
	public List<ProductOrder> getAllOrders() {
		return orderRepository.findAll();
	}
}
