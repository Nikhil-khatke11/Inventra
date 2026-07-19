package com.nikhil.inventra.service_impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nikhil.inventra.entity.Category;
import com.nikhil.inventra.exceptions_handlng.CustomExceptions;
import com.nikhil.inventra.repository.CategoryRepo;
import com.nikhil.inventra.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	private final CategoryRepo categoryRepo;

	public CategoryImpl(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public Category saveCategory(Category category) {

		if (categoryRepo.existsByNameIgnoreCase(category.getName())) {
			throw new CustomExceptions("Category already exists.");
		}

		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Long categoryId, Category category) {

		Category c = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CustomExceptions("Category not found with id " + categoryId));

		c.setName(category.getName());
		c.setDescription(category.getDescription());

		return categoryRepo.save(c);
	}

	@Override
	public void deleteCategory(Long categoryId) {

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CustomExceptions("Category not found with id: " + categoryId));

		categoryRepo.delete(category);
		
	}

	@Override
	public Category getCategoryById(Long categoryId) {

		return categoryRepo.findById(categoryId).orElseThrow(() -> new CustomExceptions("Category not found"));
	}

	@Override
	public List<Category> getAllCategories() {

		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryByName(String name) {

		return categoryRepo.findByNameContainingIgnoreCase(name);
	}

	@Override
	public boolean isCategoryExists(String name) {

		return categoryRepo.existsByNameIgnoreCase(name);
	}

	@Override
	public long getCategoryCount() {
		return categoryRepo.count();
	}

}
