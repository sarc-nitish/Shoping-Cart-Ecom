package com.ecom.shoppingcart.service;

import java.util.List;

import com.ecom.shoppingcart.model.UserDtls;

public interface UserService {

	UserDtls saveUser(UserDtls user);

	UserDtls getUserByEmail(String email);

	List<UserDtls> getAllUsers();

	void increaseFailedAttempt(UserDtls user);

	void userAccountLock(UserDtls user);

	boolean unlockAccountTimeExpired(UserDtls user);
}
