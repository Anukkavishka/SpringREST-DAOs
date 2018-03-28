package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pricing database table.
 * 
 */
@Entity
@NamedQuery(name="Pricing.findAll", query="SELECT p FROM Pricing p")
public class Pricing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pricingId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pricingCreatedDateTime;

	private String pricingCreatedUser;

	private BigDecimal pricingDiscountPrecentage;

	@Temporal(TemporalType.DATE)
	private Date pricingEffectiveDate;

	@Temporal(TemporalType.DATE)
	private Date pricingExpireDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pricingModifiedDateTime;

	private String pricingModifiedUser;

	private String pricingName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="pricing")
	private List<Product> products;

	//bi-directional many-to-one association to ProductLog
	@OneToMany(mappedBy="pricing")
	private List<ProductLog> productLogs;

	public Pricing() {
	}

	public int getPricingId() {
		return this.pricingId;
	}

	public void setPricingId(int pricingId) {
		this.pricingId = pricingId;
	}

	public Date getPricingCreatedDateTime() {
		return this.pricingCreatedDateTime;
	}

	public void setPricingCreatedDateTime(Date pricingCreatedDateTime) {
		this.pricingCreatedDateTime = pricingCreatedDateTime;
	}

	public String getPricingCreatedUser() {
		return this.pricingCreatedUser;
	}

	public void setPricingCreatedUser(String pricingCreatedUser) {
		this.pricingCreatedUser = pricingCreatedUser;
	}

	public BigDecimal getPricingDiscountPrecentage() {
		return this.pricingDiscountPrecentage;
	}

	public void setPricingDiscountPrecentage(BigDecimal pricingDiscountPrecentage) {
		this.pricingDiscountPrecentage = pricingDiscountPrecentage;
	}

	public Date getPricingEffectiveDate() {
		return this.pricingEffectiveDate;
	}

	public void setPricingEffectiveDate(Date pricingEffectiveDate) {
		this.pricingEffectiveDate = pricingEffectiveDate;
	}

	public Date getPricingExpireDate() {
		return this.pricingExpireDate;
	}

	public void setPricingExpireDate(Date pricingExpireDate) {
		this.pricingExpireDate = pricingExpireDate;
	}

	public Date getPricingModifiedDateTime() {
		return this.pricingModifiedDateTime;
	}

	public void setPricingModifiedDateTime(Date pricingModifiedDateTime) {
		this.pricingModifiedDateTime = pricingModifiedDateTime;
	}

	public String getPricingModifiedUser() {
		return this.pricingModifiedUser;
	}

	public void setPricingModifiedUser(String pricingModifiedUser) {
		this.pricingModifiedUser = pricingModifiedUser;
	}

	public String getPricingName() {
		return this.pricingName;
	}

	public void setPricingName(String pricingName) {
		this.pricingName = pricingName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setPricing(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setPricing(null);

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
		productLog.setPricing(this);

		return productLog;
	}

	public ProductLog removeProductLog(ProductLog productLog) {
		getProductLogs().remove(productLog);
		productLog.setPricing(null);

		return productLog;
	}

}