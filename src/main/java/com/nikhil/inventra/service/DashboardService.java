package com.nikhil.inventra.service;


import java.util.List;

import com.nikhil.inventra.dto.DashboardResponse;
import com.nikhil.inventra.entity.Sale;

public interface DashboardService {
	
	long getTotalProducts();
	
	long getTotalCategories();
	
	long getTotalSuppliers();
	
	long getTotalSales();
	
	long getLowStockProductCount();
	
	long getOutOfStockProductCount();
	
	Double getTodaySalesAmount();
	
	Double getMonthlySalesAmount();
	
	List<Sale> getRecentSales();
	
	
	DashboardResponse getDashboardData();
	
}
