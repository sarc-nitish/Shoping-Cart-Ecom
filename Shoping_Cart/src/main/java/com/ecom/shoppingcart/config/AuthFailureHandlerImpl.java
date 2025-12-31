package com.ecom.shoppingcart.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.ecom.shoppingcart.model.UserDtls;
import com.ecom.shoppingcart.repository.UserRepository;
import com.ecom.shoppingcart.util.AppConstant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request,
			HttpServletResponse response,
			AuthenticationException exception)
			throws IOException, ServletException {

		String email = request.getParameter("username");
		UserDtls user = userRepository.findByEmail(email);

		if (user != null) {

			if (Boolean.TRUE.equals(user.getIsEnable())) {

				if (Boolean.TRUE.equals(user.getAccountNonLocked())) {

					if (user.getFailedAttempt() < AppConstant.ATTEMPT_TIME) {
						user.setFailedAttempt(user.getFailedAttempt() + 1);
						userRepository.save(user);
					} else {
						user.setAccountNonLocked(false);
						userRepository.save(user);
						exception = new LockedException("Account locked due to failed attempts");
					}

				} else {
					exception = new LockedException("Account is locked. Try later");
				}

			} else {
				exception = new LockedException("Account is inactive");
			}

		} else {
			exception = new LockedException("Invalid email or password");
		}

		setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}
}
