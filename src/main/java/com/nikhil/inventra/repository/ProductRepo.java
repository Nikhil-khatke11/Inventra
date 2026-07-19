package com.nikhil.inventra.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nikhil.inventra.entity.Product;

public interface ProductRepo extends JpaRepository<Product , Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
	List<Product> findByCategoryId(Long categoryId);
	List<Product> findBySupplierId(Long supplierId);
	
	boolean existsByNameIgnoreCase(String name);
	@Query("SELECT p FROM Product p WHERE p.quantity <= p.minimumStock")
	List<Product> findLowStockProducts();
	@Query("SELECT COUNT(p) FROM Product p WHERE p.quantity <= p.minimumStock")
	long countLowStockProducts();
	@Query("SELECT COUNT(p) FROM Product p WHERE p.quantity = 0")
	long countOutOfStockProducts();
	
	List<Product> findByQuantity(int quantity);
	List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
	
	List<Product> findAllByOrderByPriceAsc();

	List<Product> findAllByOrderByPriceDesc();

	List<Product> findAllByOrderByNameAsc();

	List<Product> findAllByOrderByNameDesc();

	
}
