package com.ecom.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecom.shoppingcart.service.CommonService;

import jakarta.servlet.http.HttpSession;

@Service
public class CommonServiceImpl implements CommonService {

	@Value("${rupee.sign:₹}")
	private String rupeeSign;

	@Override
	public void removeSessionMessage(HttpSession session) {
		if (session != null) {
			session.removeAttribute("succMsg");
			session.removeAttribute("errorMsg");
		}
	}

	@Override
	public String rupeeSign() {
		return rupeeSign;
	}
}
