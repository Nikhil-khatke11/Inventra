package com.nikhil.inventra.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.inventra.entity.Product;
import com.nikhil.inventra.service.ProductService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
public class ProductController {
		
	
	private ProductService serv;
	
	//constructor
	public ProductController(ProductService serv) {
		this.serv = serv;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.saveProduct(product));
	}
	
	@PutMapping("/update/{productId}")
	public Product updateProduct(@Valid @PathVariable Long productId, @RequestBody Product product) {
		return serv.updateProduct(productId, product);
	}
	
	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		serv.deleteProduct(productId);
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Long productId) {
		return serv.getProductById(productId);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return serv.getAllProducts();
	}
	
	@GetMapping("/search/{name}")
	public List<Product> searchProductsByName(@PathVariable String name) {
		return serv.searchProducts(name);
	}
	
	@GetMapping("/category/{id}")
	public List<Product> getAllProductsByCategory(@PathVariable Long id){
		return serv.getProductsByCategory(id);
	}
	
	@GetMapping("/supplier/{id}")
	public List<Product> getAllBySupplierId(@PathVariable Long id){
		return serv.getProductsBySupplier(id);
	}
	
	@GetMapping("/low-stock")
	public List<Product> getAllLowStockProducts(){
		return serv.getLowStockProducts();
	}
	
	@GetMapping("/out-of-stock")
	public List<Product> getAllOutOfStockProducts(){
		return serv.getOutOfStockProducts();
	}
	
	@GetMapping("/price/{minPrice}/{maxPrice}")
	public List<Product> getProductsByPriceAndRange(@PathVariable Double minPrice , @PathVariable Double maxPrice){
		return serv.getProductsByPriceRange(minPrice, maxPrice);
	}
	
	@GetMapping("/sort/price/asc")
	public List<Product> getProductsSortedByPriceAsc(){
		return serv.sortProductsByPriceLowToHigh();
	}
	
	@GetMapping("/sort/price/desc")
	public List<Product> getProductsHighPriceToLow(){
		return serv.sortProductsByPriceHighToLow();
	}
	
	@GetMapping("/sort/name/asc")
	public List<Product> getProductsByNameAsc(){
		return serv.sortProductsByNameAsc();
	}
	
	@GetMapping("/sort/name/desc")
	public List<Product> getProductsByNameDesc(){
		return serv.sortProductsByNameDesc();
	}
	
	@GetMapping("/count")
	public long getProductsCount() {
		return serv.getProductCount();
	}
		
	@GetMapping("/page")
	public ResponseEntity<Page<Product>> getAllProductsByPagination(Pageable pageable){
		return ResponseEntity.ok(serv.getAllProducts(pageable));
	}
}
