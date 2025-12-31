package com.ecom.shoppingcart.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecom.shoppingcart.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> getLatestProducts();

	Page<Product> getAllProductsPagination(int pageNo, int pageSize);

	Product getProductById(Long id);

	List<Product> getAllProducts();
}
