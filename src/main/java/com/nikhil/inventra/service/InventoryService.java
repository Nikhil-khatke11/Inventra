package com.nikhil.inventra.service;

import java.util.List;

import com.nikhil.inventra.entity.Product;

public interface InventoryService {
	
	List<Product> getInventory();

	Product increaseStock(Long productId , int quantity);
	
	Product decreaseStock(Long productId,  int quantity);
	
	List<Product> getLowStockProducts();
	
	List<Product> getOutOfStockProducts();

}
