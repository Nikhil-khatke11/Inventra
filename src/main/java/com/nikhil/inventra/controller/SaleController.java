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
import com.nikhil.inventra.entity.Sale;
import com.nikhil.inventra.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
		
	private SaleService saleService;
	
	public SaleController(SaleService saleService) {
		this.saleService  = saleService;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Sale> saveSale(@RequestBody Sale sale){
		return ResponseEntity.status(HttpStatus.CREATED).body(saleService.createSale(sale));
	}
	
	@PutMapping("/update/{saleId}")
	public ResponseEntity<Sale> updateSale(@PathVariable Long saleId , @RequestBody Sale sale){
		return ResponseEntity.ok(saleService.updateSale(saleId, sale));
	}
	
	@DeleteMapping("/delete/{saleId}")
	public ResponseEntity<ApiResponse> deleteSaleById(@PathVariable Long saleId){
		
		saleService.deleteSale(saleId);
		
		return ResponseEntity.ok(new ApiResponse(true, "Sale deleted successfully."));
	}
	
	@GetMapping("/id/{saleId}")
	public ResponseEntity<Sale> getSaleById(@PathVariable Long saleId){
		return ResponseEntity.ok(saleService.getSaleById(saleId));
	}
	
	@GetMapping("/all-sales")
	public ResponseEntity<List<Sale>> getAllSales(){
		return ResponseEntity.ok(saleService.getAllSale());
	}
	
	@GetMapping("/today-sales-amount")
	public ResponseEntity<Double> getTodaySalesAmount(){
		return ResponseEntity.ok(saleService.getTodaySalesAmount());
	}
	
	@GetMapping("/invoice/{invoiceNumber}")
	public ResponseEntity<Sale> getSaleByInvoiceNumber(@PathVariable String invoiceNumber){
		return ResponseEntity.ok(saleService.getSaleByInvoiceNumber(invoiceNumber));
	}
	
}
