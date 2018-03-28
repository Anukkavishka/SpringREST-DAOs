package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int refId;

	@Temporal(TemporalType.DATE)
	private Date dateStock;

	private int quantity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date stockCreatedDateTime;

	private String stockCreatedUser;

	private int stockId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date stockModifiedDateTime;

	private String stockModifiedUser;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplierId")
	private Supplier supplier;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;

	public Stock() {
	}

	public int getRefId() {
		return this.refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public Date getDateStock() {
		return this.dateStock;
	}

	public void setDateStock(Date dateStock) {
		this.dateStock = dateStock;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getStockCreatedDateTime() {
		return this.stockCreatedDateTime;
	}

	public void setStockCreatedDateTime(Date stockCreatedDateTime) {
		this.stockCreatedDateTime = stockCreatedDateTime;
	}

	public String getStockCreatedUser() {
		return this.stockCreatedUser;
	}

	public void setStockCreatedUser(String stockCreatedUser) {
		this.stockCreatedUser = stockCreatedUser;
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public Date getStockModifiedDateTime() {
		return this.stockModifiedDateTime;
	}

	public void setStockModifiedDateTime(Date stockModifiedDateTime) {
		this.stockModifiedDateTime = stockModifiedDateTime;
	}

	public String getStockModifiedUser() {
		return this.stockModifiedUser;
	}

	public void setStockModifiedUser(String stockModifiedUser) {
		this.stockModifiedUser = stockModifiedUser;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}