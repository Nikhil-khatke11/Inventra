package com.nikhil.inventra.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.inventra.entity.Sale;
import com.nikhil.inventra.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	
		private DashboardService dashboardServ;
		
		public DashboardController(DashboardService dashboardServ) {
			this.dashboardServ = dashboardServ;
		}
		
		
		@GetMapping("/products-count")
		public ResponseEntity<Long> getProductsCount(){
			return ResponseEntity.ok(dashboardServ.getTotalProducts());
		}
		
		@GetMapping("/categories-count")
		public ResponseEntity<Long> getCategoriesCount(){
			return ResponseEntity.ok(dashboardServ.getTotalCategories());
		}
		
		@GetMapping("/suppliers-count")
		public ResponseEntity<Long> getSuppliersCount(){
			return ResponseEntity.ok(dashboardServ.getTotalSuppliers());
		}
		
		@GetMapping("/sales-count")
		public ResponseEntity<Long> getSalesCount(){
			return ResponseEntity.ok(dashboardServ.getTotalSales());
		}
		
		@GetMapping("/low-stock-count")
		public ResponseEntity<Long> getLowStockProductsCount(){
			return ResponseEntity.ok(dashboardServ.getLowStockProductCount());
		}
		
		@GetMapping("/out-of-stock-count")
		public ResponseEntity<Long> getOutOfStockProductsCount(){
			return ResponseEntity.ok(dashboardServ.getOutOfStockProductCount());
		}
		
		@GetMapping("/today-sales-amount")
		public ResponseEntity<Double> getTodaySalesAmount(){
			return ResponseEntity.ok(dashboardServ.getTodaySalesAmount());
		}
		
		@GetMapping("/recent-sales")
		public ResponseEntity<List<Sale>> getRecentSales(){
			return ResponseEntity.ok(dashboardServ.getRecentSales());
		}
		
}

