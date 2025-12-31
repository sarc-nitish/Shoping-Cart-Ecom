package com.ecom.shoppingcart.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.shoppingcart.model.UserDtls;
import com.ecom.shoppingcart.repository.UserRepository;
import com.ecom.shoppingcart.service.UserService;
import com.ecom.shoppingcart.util.AppConstant;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository,
						   PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDtls saveUser(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		user.setIsEnable(true);
		user.setAccountNonLocked(true);
		user.setFailedAttempt(0);
		return userRepository.save(user);
	}

	@Override
	public UserDtls getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDtls> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void increaseFailedAttempt(UserDtls user) {
		user.setFailedAttempt(user.getFailedAttempt() + 1);
		userRepository.save(user);
	}

	@Override
	public void userAccountLock(UserDtls user) {
		user.setAccountNonLocked(false);
		user.setLockTime(LocalDateTime.now());
		userRepository.save(user);
	}

	@Override
	public boolean unlockAccountTimeExpired(UserDtls user) {
		LocalDateTime lockTime = user.getLockTime();
		if (lockTime.plusMinutes(AppConstant.UNLOCK_DURATION)
				.isBefore(LocalDateTime.now())) {

			user.setAccountNonLocked(true);
			user.setFailedAttempt(0);
			user.setLockTime(null);
			userRepository.save(user);
			return true;
		}
		return false;
	}
}
