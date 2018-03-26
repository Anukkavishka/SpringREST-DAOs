package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.product.Product;
@Transactional
@Repository
public class ProductDAO implements IProduct {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public List<Product> getAllProducts() {
		String hql = "FROM Product as pr ORDER BY pr.productId";
		return (List<Product>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Product getProductById(long productId) {
		return entityManager.find(Product.class,  productId);
	}

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		Product pr = getProductById(product.getProductId());
		pr.setProductName(product.getProductName());
		pr.setIsService(product.isIsService());
		pr.setBuyingPrice(product.getBuyingPrice());
		pr.setSellingPrice(product.getSellingPrice());
		pr.setReorderLevel(product.getReorderLevel());
		entityManager.flush();
	}

	@Override
	public void deleteProduct(long productId) {
		entityManager.remove(getProductById(productId));
	}

	
	

}
