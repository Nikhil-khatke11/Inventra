package com.nikhil.inventra.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nikhil.inventra.entity.Sale;

public interface SaleRepo extends JpaRepository<Sale, Long> {
	
	boolean existsByInvoiceNumberIgnoreCase(String invoiceNumber);
	@Query("""
			SELECT COALESCE(SUM(s.totalAmount),0)
			FROM Sale s
			WHERE s.saleDate BETWEEN :startDate AND :endDate
			""")
			Double getTodaySalesAmount(
			        @Param("startDate") LocalDateTime startDate,
			        @Param("endDate") LocalDateTime endDate);
	
	@Query("""
			SELECT COALESCE(SUM(s.totalAmount),0)
			FROM Sale s
			""")
			Double getTotalSalesAmount();
	
	Sale findByInvoiceNumber(String invoiceNumber);
	List<Sale> findTop5ByOrderBySaleDateDesc();
	

	@Query("""
		       SELECT COALESCE(SUM(s.totalAmount),0)
		       FROM Sale s
		       WHERE s.saleDate BETWEEN :startDate AND :endDate
		       """)
		Double getMonthlySalesAmount(@Param("startDate")
									 LocalDateTime startDate,
									 @Param("endDate") LocalDateTime endDate);
	
}
