package com.nikhil.inventra.service_impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nikhil.inventra.entity.Category;
import com.nikhil.inventra.entity.Product;
import com.nikhil.inventra.entity.Supplier;
import com.nikhil.inventra.exceptions_handlng.CustomExceptions;
import com.nikhil.inventra.repository.CategoryRepo;
import com.nikhil.inventra.repository.ProductRepo;
import com.nikhil.inventra.repository.SupplierRepo;
import com.nikhil.inventra.service.ProductService;

@Service
public class ProductImpl implements ProductService {

	private final ProductRepo repo;
	private final CategoryRepo categoryRepo;
	private final SupplierRepo suppRepo;

	public ProductImpl(ProductRepo repo, CategoryRepo categoryRepo, SupplierRepo suppRepo) {
		this.repo = repo;
		this.categoryRepo = categoryRepo;
		this.suppRepo = suppRepo;
	}

	@Override
	public Product saveProduct(Product product) {

		if (repo.existsByNameIgnoreCase(product.getName())) {
			throw new CustomExceptions("Product already exists.");
		}

		
		Category category = categoryRepo.findById(product.getCategory().getId()).orElseThrow(() -> new CustomExceptions("Category not found"));
		
		Supplier supplier = suppRepo.findById(product.getSupplier().getId()).orElseThrow(() -> new CustomExceptions("Supplier not found"));
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		return repo.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product product) {

		Product p = repo.findById(id).orElseThrow(() -> new CustomExceptions("Product not found with id "+id+" for update."));

		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setQuantity(product.getQuantity());
		p.setMinimumStock(product.getMinimumStock());

		Category category = categoryRepo.findById(product.getCategory().getId())
		        .orElseThrow(() -> new CustomExceptions("Category not found"));

		Supplier supplier = suppRepo.findById(product.getSupplier().getId())
		        .orElseThrow(() -> new CustomExceptions("Supplier not found"));

		p.setCategory(category);
		p.setSupplier(supplier);
		
		return repo.save(p);
	}

	@Override
	public void deleteProduct(Long id) {
		
		Product product = repo.findById(id).orElseThrow(() -> new CustomExceptions("Product not found for delete"));
	}

	@Override
	public Product getProductById(Long id) {
		return repo.findById(id).orElseThrow(() -> new CustomExceptions("Product not found with id: " + id));
	}

	@Override
	public List<Product> getAllProducts() {

		return repo.findAll();
	}

	@Override
	public List<Product> searchProducts(String name) {

		return repo.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Product> getProductsByCategory(Long categoryId) {

		categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CustomExceptions("Category not found with id: " + categoryId));

		return repo.findByCategoryId(categoryId);

	}

	@Override
	public List<Product> getProductsBySupplier(Long supplierId) {
		suppRepo.findById(supplierId)
				.orElseThrow(() -> new CustomExceptions("Supplier not found with id: " + supplierId));
		return repo.findBySupplierId(supplierId);
	}

	@Override
	public List<Product> getLowStockProducts() {
		return repo.findLowStockProducts();
	}

	@Override
	public List<Product> getOutOfStockProducts() {

		return repo.findByQuantity(0);
	}

	@Override
	public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {

		if (minPrice > maxPrice) {
			throw new CustomExceptions("Minimum price cannot be greater than maximum price.");
		}

		return repo.findByPriceBetween(minPrice, maxPrice);
	}

	@Override
	public List<Product> sortProductsByPriceLowToHigh() {

		return repo.findAllByOrderByPriceAsc();
	}

	@Override
	public List<Product> sortProductsByPriceHighToLow() {

		return repo.findAllByOrderByPriceDesc();
	}

	@Override
	public List<Product> sortProductsByNameAsc() {

		return repo.findAllByOrderByNameAsc();
	}

	@Override
	public List<Product> sortProductsByNameDesc() {

		return repo.findAllByOrderByNameDesc();
	}

	@Override
	public long getProductCount() {

		return repo.count();
	}

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
