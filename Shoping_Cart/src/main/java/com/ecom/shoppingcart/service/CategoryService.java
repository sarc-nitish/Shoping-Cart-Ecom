package com.ecom.shoppingcart.service;

import java.util.List;

import com.ecom.shoppingcart.model.Category;

public interface CategoryService {

	List<Category> getAllCategory();

	List<Category> getAllActiveCategory();

	Category saveCategory(Category category);
}
