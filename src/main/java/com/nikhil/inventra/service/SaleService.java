package com.nikhil.inventra.service;

import java.util.List;

import com.nikhil.inventra.entity.Sale;

public interface SaleService {
	
	Sale createSale(Sale sale);
	
	Sale updateSale(Long id, Sale sale);
	
	void deleteSale(Long id);
	
	Sale getSaleById(Long id);
	
	List<Sale> getAllSale();
	
	Double getTodaySalesAmount();
	
	Double getMonthlySalesAmount();
	
	Sale getSaleByInvoiceNumber(String invoiceNumber);
	
	Double getTotalSalesAmount();
	
	long getSaleCount();
	
}
