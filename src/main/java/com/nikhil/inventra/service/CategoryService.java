package com.nikhil.inventra.service;

import java.util.List;

import com.nikhil.inventra.entity.Category;

public interface CategoryService {
	
	Category saveCategory(Category category);
	
	Category updateCategory(Long id, Category category);
	
	void deleteCategory(Long id);
	
	Category getCategoryById(Long id);
	
	List<Category> getAllCategories();
	
	Category getCategoryByName(String name);
	
	boolean isCategoryExists(String name);
	
	long getCategoryCount();
	
}
