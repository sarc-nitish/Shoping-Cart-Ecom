package com.ecom.shoppingcart.util;

import java.util.UUID;

public final class CommonUtil {

	private CommonUtil() {
		// utility class
	}

	// Generate random order id
	public static String generateOrderId() {
		return UUID.randomUUID().toString();
	}

	// Calculate discount price
	public static double calculateDiscount(double price, double discount) {
		if (discount <= 0) {
			return price;
		}
		return price - (price * discount / 100);
	}
}
