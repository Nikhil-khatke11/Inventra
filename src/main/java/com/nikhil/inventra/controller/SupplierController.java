package com.nikhil.inventra.controller;

import java.util.List;

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

import com.nikhil.inventra.dto.ApiResponse;
import com.nikhil.inventra.entity.Supplier;
import com.nikhil.inventra.service.SupplierService;



@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	
	private SupplierService supplierServ;
	
	//constructor
	public SupplierController(SupplierService supplierServ) {
		this.supplierServ = supplierServ;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier){
		return ResponseEntity.status(HttpStatus.CREATED).body(supplierServ.saveSupplier(supplier));
	}
	
	
	@PutMapping("/update/{supplierId}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable Long supplierId, @RequestBody Supplier supplier){
		return ResponseEntity.ok(supplierServ.updateSupplier(supplierId, supplier));
	}
	
	@DeleteMapping("/delete/{supplierId}")
	public ResponseEntity<ApiResponse> deleteSupplier(@PathVariable Long supplierId){
		supplierServ.deleteSupplier(supplierId);
		return ResponseEntity.ok(new ApiResponse(true , "Supplier deleted successfully."));
	}
	
	
	@GetMapping("/id/{supplierId}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable Long supplierId){
		return ResponseEntity.ok(supplierServ.getSupplierById(supplierId));
	}
	
	
	@GetMapping("/all-suppliers")
	public ResponseEntity<List<Supplier>> getAllSuppliers(){
		return ResponseEntity.ok(supplierServ.getAllSuppliers());
	}
	
	@GetMapping("/mail/{mail}")
	public ResponseEntity<Supplier> getSupplierByMail(@PathVariable String mail){
		return ResponseEntity.ok(supplierServ.getSupplierByEmail(mail));
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<Supplier>> searchSupplierByName(@PathVariable String name){
		return ResponseEntity.ok(supplierServ.searchSupplier(name));
	}
	
	
}
