package com.nikhil.inventra.service_impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nikhil.inventra.entity.Product;
import com.nikhil.inventra.exceptions_handlng.CustomExceptions;
import com.nikhil.inventra.repository.ProductRepo;
import com.nikhil.inventra.service.InventoryService;

@Service
public class InventoryImpl implements InventoryService {

	
	private final ProductRepo productRepo;
	
	
	public InventoryImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public List<Product> getInventory(){
		return productRepo.findAll() ;
	}

	@Override
	public Product increaseStock(Long productId, int quantity) {
		Product product = productRepo.findById(productId).orElseThrow(() -> new CustomExceptions("product not found to increase stock"));
	
		if(quantity <= 0) {
			throw new CustomExceptions("Quantity must be greater than 0");
		}
		
		product.setQuantity(product.getQuantity() + quantity);
		
		return productRepo.save(product);
	}

	@Override
	public Product decreaseStock(Long productId, int quantity) {
		
		Product product = productRepo.findById(productId).orElseThrow(() -> new CustomExceptions("Product not found to decrease stock"));
		
		if(product.getQuantity() < quantity) {
			throw new CustomExceptions("Insufficient stock");
		}
		
		product.setQuantity(product.getQuantity() - quantity);
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getLowStockProducts() {
		
		return productRepo.findLowStockProducts();
	}

	@Override
	public List<Product> getOutOfStockProducts() {
		
		return productRepo.findByQuantity(0);
	}
	
}
