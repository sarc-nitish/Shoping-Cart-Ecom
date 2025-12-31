package com.ecom.shoppingcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.shoppingcart.model.UserDtls;

@Repository
public interface UserRepository extends JpaRepository<UserDtls, Long> {

	UserDtls findByEmail(String email);

	Optional<UserDtls> findById(Long id);
}
