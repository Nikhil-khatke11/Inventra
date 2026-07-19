package com.nikhil.inventra.service_impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.nikhil.inventra.entity.Sale;
import com.nikhil.inventra.exceptions_handlng.CustomExceptions;
import com.nikhil.inventra.repository.SaleRepo;
import com.nikhil.inventra.service.SaleService;

@Service
public class SaleImpl implements SaleService {

	private final SaleRepo saleRepo;
	
	
	public SaleImpl(SaleRepo saleRepo) {
		this.saleRepo = saleRepo;
	}
	
	@Override
	public Sale createSale(Sale sale) {
		
		String invoiceNumber;
		
		do {
			invoiceNumber = generateInvoiceNumber();
		}while(saleRepo.existsByInvoiceNumberIgnoreCase(invoiceNumber));
			sale.setInvoiceNumber(invoiceNumber);
			sale.setSaleDate(LocalDateTime.now());
			
			return saleRepo.save(sale);
		}
		

	@Override
	public Sale updateSale(Long saleId, Sale sale) {
		
		
		Sale s = saleRepo.findById(saleId).orElseThrow(() -> new CustomExceptions("Sale not found with id  "+saleId));
		
	s.setTotalAmount(sale.getTotalAmount());
		
		return saleRepo.save(s);
	}
	
	// for generate invoice number
	private String generateInvoiceNumber() {

	    return "INV-"
	            + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
	            + "-"
	            + ThreadLocalRandom.current().nextInt(1000, 9999);
	}

	@Override
	public void deleteSale(Long saleId) {
	
	Sale s = saleRepo.findById(saleId).orElseThrow(() -> new CustomExceptions("Sale not found for delete"));
		
		saleRepo.delete(s);
	}

	@Override
	public Sale getSaleById(Long saleId) {
		
		return saleRepo.findById(saleId).orElseThrow(() -> new CustomExceptions("Sale not found with id: "+saleId));
	}

	@Override
	public List<Sale> getAllSale() {
		
		return saleRepo.findAll();
	}

	@Override
	public Double getTodaySalesAmount() {

	    LocalDate today = LocalDate.now();

	    LocalDateTime startDate =
	            today.atStartOfDay();

	    LocalDateTime endDate =
	            today.atTime(LocalTime.MAX);

	    return saleRepo.getTodaySalesAmount(startDate, endDate);

	}
 
	// we'll implement getMonthlySalesAmount() later
	@Override
	public Double getMonthlySalesAmount() {
		
		LocalDate today = LocalDate.now();
		LocalDateTime startDate = today.withDayOfMonth(1).atStartOfDay();
		
		LocalDateTime endDate = today.withDayOfMonth(today.lengthOfMonth()).atTime(LocalTime.MAX); 
		
		return saleRepo.getMonthlySalesAmount(startDate, endDate);
	}
	
	@Override
	public Sale getSaleByInvoiceNumber(String invoiceNumber) {
		
		return saleRepo.findByInvoiceNumber(invoiceNumber);
	}


	
	@Override
	public Double getTotalSalesAmount() {
		return saleRepo.getTotalSalesAmount();
	}


	@Override
	public long getSaleCount() {
		return saleRepo.count();
	}
	
		
}
