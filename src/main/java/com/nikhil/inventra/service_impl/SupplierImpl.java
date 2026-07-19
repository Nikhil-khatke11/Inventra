package com.nikhil.inventra.service_impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nikhil.inventra.entity.Supplier;
import com.nikhil.inventra.exceptions_handlng.CustomExceptions;
import com.nikhil.inventra.repository.SupplierRepo;
import com.nikhil.inventra.service.SupplierService;

@Service
public class SupplierImpl implements SupplierService {

	private final SupplierRepo supplierRepo;

	public SupplierImpl(SupplierRepo supplierRepo) {

		this.supplierRepo = supplierRepo;
	}

	public Supplier saveSupplier(Supplier supplier) {

		if (supplierRepo.existsByNameIgnoreCase(supplier.getName())) {
			throw new CustomExceptions("Supplier already exists with name " + supplier.getName());
		}

		return supplierRepo.save(supplier);
	}

	@Override
	public Supplier updateSupplier(Long id, Supplier supplier) {

		Supplier supp = supplierRepo.findById(id)
				.orElseThrow(() -> new CustomExceptions("Supplier not found with id " + id));

		supp.setName(supplier.getName());
		supp.setEmail(supplier.getEmail());
		supp.setPhoneNumber(supplier.getPhoneNumber());
		supp.setAddress(supplier.getAddress());

		return supplierRepo.save(supp);
	}

	@Override
	public void deleteSupplier(Long id) {

		Supplier supp = supplierRepo.findById(id)
				.orElseThrow(() -> new CustomExceptions("Supplier not found with id " + id + " to delete."));
		supplierRepo.delete(supp);
	}

	@Override
	public Supplier getSupplierById(Long id) {

		return supplierRepo.findById(id).orElseThrow(() -> new CustomExceptions("Supplier not found with id " + id));
	}

	@Override
	public List<Supplier> getAllSuppliers() {

		return supplierRepo.findAll();
	}

	@Override
	public Supplier getSupplierByEmail(String email) {
		return supplierRepo.findByEmailIgnoreCase(email);
	}

	@Override
	public List<Supplier> searchSupplier(String keyword) {

		return supplierRepo.findAllByNameContainingIgnoreCase(keyword);
	}

	@Override
	public boolean isSupplierEmailExists(String email) {

		return supplierRepo.existsByEmailIgnoreCase(email);
	}

	@Override
	public long getSupplierCount() {

		return supplierRepo.count();
	}

}
