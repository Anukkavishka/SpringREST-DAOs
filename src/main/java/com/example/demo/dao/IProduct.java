package com.example.demo.dao;

import java.util.List;

import com.example.demo.resources.Product;

public interface IProduct {
	
	List<Product> getAllProducts();
    Product getProductById(long productId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(long productId);
   
}
