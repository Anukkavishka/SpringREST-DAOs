package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productId;

	private double productbuyingPrice;

	@Temporal(TemporalType.TIMESTAMP)
	private Date productCreatedDateTime;

	private String productCreatedUser;

	private byte productIsService;

	@Temporal(TemporalType.TIMESTAMP)
	private Date productModifiedDateTime;

	private String productModifiedUser;

	private String productName;

	private double productsellingPrice;

	//bi-directional many-to-one association to Pricing
	@ManyToOne
	@JoinColumn(name="pricingId")
	private Pricing pricing;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="product")
	private List<Stock> stocks;

	//bi-directional many-to-one association to StockLog
	@OneToMany(mappedBy="product")
	private List<StockLog> stockLogs;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getProductbuyingPrice() {
		return this.productbuyingPrice;
	}

	public void setProductbuyingPrice(double productbuyingPrice) {
		this.productbuyingPrice = productbuyingPrice;
	}

	public Date getProductCreatedDateTime() {
		return this.productCreatedDateTime;
	}

	public void setProductCreatedDateTime(Date productCreatedDateTime) {
		this.productCreatedDateTime = productCreatedDateTime;
	}

	public String getProductCreatedUser() {
		return this.productCreatedUser;
	}

	public void setProductCreatedUser(String productCreatedUser) {
		this.productCreatedUser = productCreatedUser;
	}

	public byte getProductIsService() {
		return this.productIsService;
	}

	public void setProductIsService(byte productIsService) {
		this.productIsService = productIsService;
	}

	public Date getProductModifiedDateTime() {
		return this.productModifiedDateTime;
	}

	public void setProductModifiedDateTime(Date productModifiedDateTime) {
		this.productModifiedDateTime = productModifiedDateTime;
	}

	public String getProductModifiedUser() {
		return this.productModifiedUser;
	}

	public void setProductModifiedUser(String productModifiedUser) {
		this.productModifiedUser = productModifiedUser;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductsellingPrice() {
		return this.productsellingPrice;
	}

	public void setProductsellingPrice(double productsellingPrice) {
		this.productsellingPrice = productsellingPrice;
	}

	public Pricing getPricing() {
		return this.pricing;
	}

	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProduct(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProduct(null);

		return stock;
	}

	public List<StockLog> getStockLogs() {
		return this.stockLogs;
	}

	public void setStockLogs(List<StockLog> stockLogs) {
		this.stockLogs = stockLogs;
	}

	public StockLog addStockLog(StockLog stockLog) {
		getStockLogs().add(stockLog);
		stockLog.setProduct(this);

		return stockLog;
	}

	public StockLog removeStockLog(StockLog stockLog) {
		getStockLogs().remove(stockLog);
		stockLog.setProduct(null);

		return stockLog;
	}

}