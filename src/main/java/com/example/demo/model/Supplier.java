package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int supplierId;

	private String supplierCompany;

	private BigDecimal supplierContact;

	@Temporal(TemporalType.TIMESTAMP)
	private Date supplierCreatedDateTime;

	private String supplierCreatedUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date supplierModifiedDateTime;

	private String supplierModifiedUser;

	private String supplierName;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="supplier")
	private List<Stock> stocks;

	//bi-directional many-to-one association to StockLog
	@OneToMany(mappedBy="supplier")
	private List<StockLog> stockLogs;

	public Supplier() {
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierCompany() {
		return this.supplierCompany;
	}

	public void setSupplierCompany(String supplierCompany) {
		this.supplierCompany = supplierCompany;
	}

	public BigDecimal getSupplierContact() {
		return this.supplierContact;
	}

	public void setSupplierContact(BigDecimal supplierContact) {
		this.supplierContact = supplierContact;
	}

	public Date getSupplierCreatedDateTime() {
		return this.supplierCreatedDateTime;
	}

	public void setSupplierCreatedDateTime(Date supplierCreatedDateTime) {
		this.supplierCreatedDateTime = supplierCreatedDateTime;
	}

	public String getSupplierCreatedUser() {
		return this.supplierCreatedUser;
	}

	public void setSupplierCreatedUser(String supplierCreatedUser) {
		this.supplierCreatedUser = supplierCreatedUser;
	}

	public Date getSupplierModifiedDateTime() {
		return this.supplierModifiedDateTime;
	}

	public void setSupplierModifiedDateTime(Date supplierModifiedDateTime) {
		this.supplierModifiedDateTime = supplierModifiedDateTime;
	}

	public String getSupplierModifiedUser() {
		return this.supplierModifiedUser;
	}

	public void setSupplierModifiedUser(String supplierModifiedUser) {
		this.supplierModifiedUser = supplierModifiedUser;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setSupplier(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setSupplier(null);

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
		stockLog.setSupplier(this);

		return stockLog;
	}

	public StockLog removeStockLog(StockLog stockLog) {
		getStockLogs().remove(stockLog);
		stockLog.setSupplier(null);

		return stockLog;
	}

}