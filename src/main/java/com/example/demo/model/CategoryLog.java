package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the category_log database table.
 * 
 */
@Entity
@Table(name="category_log")
@NamedQuery(name="CategoryLog.findAll", query="SELECT c FROM CategoryLog c")
public class CategoryLog implements Serializable {
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

	public CategoryLog() {
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

}