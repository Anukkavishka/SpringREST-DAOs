package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int categoryId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date categoryCreatedDateTime;

	private String categoryCreatedUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date categoryModifiedDateTime;

	private String categoryModifiedUser;

	private String categoryName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<Product> products;

	//bi-directional many-to-one association to ProductLog
	@OneToMany(mappedBy="category")
	private List<ProductLog> productLogs;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="category")
	private List<Stock> stocks;

	//bi-directional many-to-one association to StockLog
	@OneToMany(mappedBy="category")
	private List<StockLog> stockLogs;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCategoryCreatedDateTime() {
		return this.categoryCreatedDateTime;
	}

	public void setCategoryCreatedDateTime(Date categoryCreatedDateTime) {
		this.categoryCreatedDateTime = categoryCreatedDateTime;
	}

	public String getCategoryCreatedUser() {
		return this.categoryCreatedUser;
	}

	public void setCategoryCreatedUser(String categoryCreatedUser) {
		this.categoryCreatedUser = categoryCreatedUser;
	}

	public Date getCategoryModifiedDateTime() {
		return this.categoryModifiedDateTime;
	}

	public void setCategoryModifiedDateTime(Date categoryModifiedDateTime) {
		this.categoryModifiedDateTime = categoryModifiedDateTime;
	}

	public String getCategoryModifiedUser() {
		return this.categoryModifiedUser;
	}

	public void setCategoryModifiedUser(String categoryModifiedUser) {
		this.categoryModifiedUser = categoryModifiedUser;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	public List<ProductLog> getProductLogs() {
		return this.productLogs;
	}

	public void setProductLogs(List<ProductLog> productLogs) {
		this.productLogs = productLogs;
	}

	public ProductLog addProductLog(ProductLog productLog) {
		getProductLogs().add(productLog);
		productLog.setCategory(this);

		return productLog;
	}

	public ProductLog removeProductLog(ProductLog productLog) {
		getProductLogs().remove(productLog);
		productLog.setCategory(null);

		return productLog;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setCategory(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setCategory(null);

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
		stockLog.setCategory(this);

		return stockLog;
	}

	public StockLog removeStockLog(StockLog stockLog) {
		getStockLogs().remove(stockLog);
		stockLog.setCategory(null);

		return stockLog;
	}

}