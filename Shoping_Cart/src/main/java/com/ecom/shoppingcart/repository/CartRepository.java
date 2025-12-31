package com.ecom.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.shoppingcart.model.Cart;
import com.ecom.shoppingcart.model.UserDtls;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByUser(UserDtls user);

	Cart findByUserAndProduct_Id(UserDtls user, Long productId);
}
