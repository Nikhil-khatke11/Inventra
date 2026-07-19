package com.nikhil.inventra.service_impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nikhil.inventra.dto.DashboardResponse;
import com.nikhil.inventra.entity.Sale;
import com.nikhil.inventra.repository.CategoryRepo;
import com.nikhil.inventra.repository.ProductRepo;
import com.nikhil.inventra.repository.SaleRepo;
import com.nikhil.inventra.repository.SupplierRepo;
import com.nikhil.inventra.service.DashboardService;
import com.nikhil.inventra.service.SaleService;

@Service
public class DashboardImpl implements DashboardService{
	
		private final SaleService saleServ;
		private final ProductRepo productRepo;
		private final CategoryRepo categoryRepo;
		private final SaleRepo saleRepo;
		private final SupplierRepo supplierRepo;
		
		public DashboardImpl(SaleService saleServ,ProductRepo productRepo, CategoryRepo categoryRepo, 
				SaleRepo saleRepo, SupplierRepo supplierRepo) {
			
			this.saleServ = saleServ;
			this.productRepo = productRepo;
			this.categoryRepo = categoryRepo;
			this.saleRepo = saleRepo;
			this.supplierRepo = supplierRepo;
		}
	
	@Override
	public long getTotalProducts() {
		
		return productRepo.count();
	}

	@Override
	public long getTotalCategories() {
		return categoryRepo.count();
	}

	@Override
	public long getTotalSuppliers() {
		
		return supplierRepo.count();
	}

	@Override
	public long getTotalSales() {
		
		return saleServ.getSaleCount();
	}

	@Override
	public long getLowStockProductCount() {
		
		return productRepo.countLowStockProducts();
	}

	@Override
	public long getOutOfStockProductCount() {
		
		return productRepo.countOutOfStockProducts();
	}

	@Override
	public Double getTodaySalesAmount() {
		
		return saleServ.getTodaySalesAmount();
	}

	@Override
	public Double getMonthlySalesAmount() {

		return saleServ.getMonthlySalesAmount();
	}

	@Override
	public List<Sale> getRecentSales() {
	
		return saleRepo.findTop5ByOrderBySaleDateDesc();
	}
	
	
	@Override
	public DashboardResponse getDashboardData() {

	    DashboardResponse response = new DashboardResponse();

	    response.setTotalProducts(getTotalProducts());

	    response.setTotalCategories(getTotalCategories());

	    response.setTotalSuppliers(getTotalSuppliers());

	    response.setTotalSales(getTotalSales());

	    response.setLowStockProducts(getLowStockProductCount());

	    response.setOutOfStockProducts(getOutOfStockProductCount());

	    response.setTodaySalesAmount(getTodaySalesAmount());

	    response.setMonthlySalesAmount(getMonthlySalesAmount());

	    response.setRecentSales(getRecentSales());

	    return response;
	}
	
}
