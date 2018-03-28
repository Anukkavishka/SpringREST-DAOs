package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {

	public Category() {
		super();
			
	}
	
	public Category(long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	private String categoryName;
	@OneToMany
	private Collection<Product> products =new ArrayList<Product>();
	
	
	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

	
	
	
	
	
	
}
