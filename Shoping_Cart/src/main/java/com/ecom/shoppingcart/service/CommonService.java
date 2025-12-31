package com.ecom.shoppingcart.service;

import jakarta.servlet.http.HttpSession;

public interface CommonService {

	void removeSessionMessage(HttpSession session);

	String rupeeSign();
}
