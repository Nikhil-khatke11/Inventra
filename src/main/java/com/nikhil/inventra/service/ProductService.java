package com.nikhil.inventra.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nikhil.inventra.entity.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	
	Product updateProduct(Long id, Product product);
	
	void deleteProduct(Long id);
	
	Product getProductById(Long id);
	
	List<Product> getAllProducts();
	
	List<Product> searchProducts(String name);
	
	List<Product> getProductsByCategory(Long categoryId);
	
	List<Product> getProductsBySupplier(Long supplierId);
	
	List<Product> getLowStockProducts();
	
	List<Product> getOutOfStockProducts();
	
	List<Product> getProductsByPriceRange(Double minPrice , Double maxPrice);
	
	List<Product> sortProductsByPriceLowToHigh();
	
	List<Product> sortProductsByPriceHighToLow();
	
	List<Product> sortProductsByNameAsc();
	
	List<Product> sortProductsByNameDesc();
	
	Page<Product> getAllProducts(Pageable pageable);
	
	long getProductCount();
	
}
