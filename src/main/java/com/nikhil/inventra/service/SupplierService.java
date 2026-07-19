package com.nikhil.inventra.service;

import java.util.List;

import com.nikhil.inventra.entity.Supplier;

public interface SupplierService {
	
	Supplier saveSupplier(Supplier supplier);
	
	Supplier updateSupplier(Long id, Supplier supplier);
	
	void deleteSupplier(Long id);
	
	Supplier getSupplierById(Long id);
	
	List<Supplier> getAllSuppliers();
	
	Supplier getSupplierByEmail(String email);
	
	List<Supplier> searchSupplier(String keyword);
	
	boolean isSupplierEmailExists(String email);
	
	long getSupplierCount();
}
