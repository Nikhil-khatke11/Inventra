package com.nikhil.inventra.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.inventra.entity.Product;
import com.nikhil.inventra.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	private InventoryService inventoryServ;
	
	public InventoryController(InventoryService inventoryServ) {
		this.inventoryServ = inventoryServ;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getInventory(){
		return ResponseEntity.ok(inventoryServ.getInventory());
	}
	
	@PutMapping("/increase/{productId}/{quantity}")
	public ResponseEntity<Product> increaseStock(@PathVariable Long productId , @PathVariable int quantity){
		return ResponseEntity.ok(inventoryServ.increaseStock(productId, quantity));
	}
	
	@PutMapping("/decrease/{productId}/{quantity}")
	public ResponseEntity<Product> decreaseStock(@PathVariable Long productId , @PathVariable int quantity){
		return ResponseEntity.ok(inventoryServ.decreaseStock(productId, quantity));
	}
	
	@GetMapping("/low-stocks")
	public ResponseEntity<List<Product>> getAllLowStockProducts(){
		return ResponseEntity.ok(inventoryServ.getLowStockProducts());
	}
			
	@GetMapping("/out-of-stocks")
	public ResponseEntity<List<Product>> getAllOutOfStockProducts(){
		return ResponseEntity.ok(inventoryServ.getOutOfStockProducts());
	}
}
