package com.nikhil.inventra.dto;

import java.util.List;

import com.nikhil.inventra.entity.Sale;

public class DashboardResponse {

    private long totalProducts;
    private long totalCategories;
    private long totalSuppliers;
    private long totalSales;

    private long lowStockProducts;
    private long outOfStockProducts;

    private Double todaySalesAmount;
    private Double monthlySalesAmount;

    private List<Sale> recentSales;

	public DashboardResponse() {
		super();
	}

	public DashboardResponse(long totalProducts, long totalCategories, long totalSuppliers, long totalSales,
			long lowStockProducts, long outOfStockProducts, Double todaySalesAmount, Double monthlySalesAmount,
			List<Sale> recentSales) {
		super();
		this.totalProducts = totalProducts;
		this.totalCategories = totalCategories;
		this.totalSuppliers = totalSuppliers;
		this.totalSales = totalSales;
		this.lowStockProducts = lowStockProducts;
		this.outOfStockProducts = outOfStockProducts;
		this.todaySalesAmount = todaySalesAmount;
		this.monthlySalesAmount = monthlySalesAmount;
		this.recentSales = recentSales;
	}

	public long getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(long totalProducts) {
		this.totalProducts = totalProducts;
	}

	public long getTotalCategories() {
		return totalCategories;
	}

	public void setTotalCategories(long totalCategories) {
		this.totalCategories = totalCategories;
	}

	public long getTotalSuppliers() {
		return totalSuppliers;
	}

	public void setTotalSuppliers(long totalSuppliers) {
		this.totalSuppliers = totalSuppliers;
	}

	public long getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(long totalSales) {
		this.totalSales = totalSales;
	}

	public long getLowStockProducts() {
		return lowStockProducts;
	}

	public void setLowStockProducts(long lowStockProducts) {
		this.lowStockProducts = lowStockProducts;
	}

	public long getOutOfStockProducts() {
		return outOfStockProducts;
	}

	public void setOutOfStockProducts(long outOfStockProducts) {
		this.outOfStockProducts = outOfStockProducts;
	}

	public Double getTodaySalesAmount() {
		return todaySalesAmount;
	}

	public void setTodaySalesAmount(Double todaySalesAmount) {
		this.todaySalesAmount = todaySalesAmount;
	}

	public Double getMonthlySalesAmount() {
		return monthlySalesAmount;
	}

	public void setMonthlySalesAmount(Double monthlySalesAmount) {
		this.monthlySalesAmount = monthlySalesAmount;
	}

	public List<Sale> getRecentSales() {
		return recentSales;
	}

	public void setRecentSales(List<Sale> recentSales) {
		this.recentSales = recentSales;
	}

   
}