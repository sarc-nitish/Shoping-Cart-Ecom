package com.ecom.shoppingcart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.shoppingcart.model.Category;
import com.ecom.shoppingcart.repository.CategoryRepository;
import com.ecom.shoppingcart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> getAllActiveCategory() {
		return categoryRepository.findByIsActiveTrue();
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
}
