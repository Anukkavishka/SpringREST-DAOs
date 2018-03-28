package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product_log database table.
 * 
 */
@Entity
@Table(name="product_log")
@NamedQuery(name="ProductLog.findAll", query="SELECT p FROM ProductLog p")
public class ProductLog implements Serializable {
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

	public ProductLog() {
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

}