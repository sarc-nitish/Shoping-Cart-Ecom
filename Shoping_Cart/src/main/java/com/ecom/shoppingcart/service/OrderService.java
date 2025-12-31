package com.ecom.shoppingcart.service;

import java.util.List;

import com.ecom.shoppingcart.model.ProductOrder;

public interface OrderService {

	void placeOrder(String email, Object request);

	List<ProductOrder> getOrdersByUser(String email);

	List<ProductOrder> getAllOrders();
}
