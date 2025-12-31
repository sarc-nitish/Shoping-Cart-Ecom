package com.ecom.shoppingcart.util;

public final class AppConstant {

	private AppConstant() {
		// prevent object creation
	}

	// Login attempt related
	public static final int ATTEMPT_TIME = 3;

	// Account unlock time (in minutes)
	public static final int UNLOCK_DURATION = 15;

	// Default roles
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	// Session messages
	public static final String SUCCESS_MSG = "succMsg";
	public static final String ERROR_MSG = "errorMsg";
}
