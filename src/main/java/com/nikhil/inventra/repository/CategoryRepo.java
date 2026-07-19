package com.nikhil.inventra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.inventra.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
	
	Category findByNameContainingIgnoreCase(String name);
	boolean existsByNameIgnoreCase(String name);
	
}
