package com.ecom.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ecom.shoppingcart.model.Product;
import com.ecom.shoppingcart.repository.ProductRepository;
import com.ecom.shoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getLatestProducts() {
		return productRepository.findTop8ByOrderByIdDesc();
	}

	@Override
	public Page<Product> getAllProductsPagination(int pageNo, int pageSize) {
		return productRepository.findAll(PageRequest.of(pageNo, pageSize));
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
