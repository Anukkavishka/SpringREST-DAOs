package com.example.demo.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IProduct;
import com.example.demo.resources.Product;

@Repository
public class ProductDAO implements IProduct {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public List<Product> getAllProducts() {
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> query=cb.createQuery(Product.class);
		Root<Product> root=query.from(Product.class);
		query.select(root);
		TypedQuery<Product> resultqry=entityManager.createQuery(query);
	
		return (List<Product>) resultqry.getResultList();
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
