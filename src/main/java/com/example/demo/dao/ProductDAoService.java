package com.example.demo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.product.Product;


@Service
public class ProductDAoService {

	

	
	public ProductDAoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private IProduct productDAO;

	public Product getProductById(long productId) {
		Product obj = productDAO.getProductById(productId);
		return obj;
	}	
	
	public List<Product> getAllProducts(){
		return productDAO.getAllProducts();
	}

	public synchronized void addProduct(Product product){
        productDAO.addProduct(product);
    	        
	}
	
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	
	public void deleteProduct(long productId) {
		productDAO.deleteProduct(productId);
	}
	


}
