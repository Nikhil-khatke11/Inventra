package com.nikhil.inventra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.inventra.dto.ApiResponse;
import com.nikhil.inventra.entity.Category;
import com.nikhil.inventra.service.CategoryService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/save")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {

		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(category));
	}

	@PutMapping("/update/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
		return ResponseEntity.ok(categoryService.updateCategory(categoryId, category));
	}

	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.ok(new ApiResponse(true, "Category deleted successfully"));
	}

	@GetMapping("/id/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}

	@GetMapping("/all-categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	@GetMapping("/search/{name}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
		return ResponseEntity.ok(categoryService.getCategoryByName(name));
	}

}
