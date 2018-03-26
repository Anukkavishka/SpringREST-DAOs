package com.example.demo.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	public Product() {
		super();
			
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	
	private String productName;
	private boolean isService;
	private double buyingPrice;
	private double sellingPrice;
	private double reorderLevel;
	
	//need to add product category, and product pricing id
	

	
	public long getProductId() {
		return productId;
	}
	
	public Product(long productId, String productName, boolean isService, double buyingPrice, double sellingPrice,
			double reorderLevel) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.isService = isService;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.reorderLevel = reorderLevel;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public boolean isIsService() {
		return isService;
	}
	public void setIsService(boolean isService) {
		this.isService = isService;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public double getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(double reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	
	
	
}
