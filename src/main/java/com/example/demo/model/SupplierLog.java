package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the supplier_log database table.
 * 
 */
@Entity
@Table(name="supplier_log")
@NamedQuery(name="SupplierLog.findAll", query="SELECT s FROM SupplierLog s")
public class SupplierLog implements Serializable {
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

	public SupplierLog() {
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

}