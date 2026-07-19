package com.nikhil.inventra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.inventra.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Long>{
	boolean existsByNameIgnoreCase(String name);
	Supplier findByNameContainingIgnoreCase(String name);		
	List<Supplier> findAllByNameContainingIgnoreCase(String keyword);
	Supplier findByEmailIgnoreCase(String email);
	boolean existsByEmailIgnoreCase(String email);
}