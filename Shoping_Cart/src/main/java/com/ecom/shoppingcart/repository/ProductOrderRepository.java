package com.ecom.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.shoppingcart.model.ProductOrder;
import com.ecom.shoppingcart.model.UserDtls;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    List<ProductOrder> findByUser(UserDtls user);

    ProductOrder findByOrderId(String orderId);
}
