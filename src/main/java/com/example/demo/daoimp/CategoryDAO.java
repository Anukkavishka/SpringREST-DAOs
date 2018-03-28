package com.example.demo.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ICategory;
import com.example.demo.resources.Category;

@Repository
public class CategoryDAO implements ICategory {

	@PersistenceContext	
	private EntityManager entityManager;	
	

	@Override
	public List<Category> getAllCategories() {
				CriteriaBuilder cb=entityManager.getCriteriaBuilder();
				CriteriaQuery<Category> query=cb.createQuery(Category.class);
				Root<Category> root=query.from(Category.class);
				query.select(root);
				//query.select(root).where(cb.equal(root.get("categoryName"),"Veges"));
				TypedQuery<Category> resultqry=entityManager.createQuery(query);
				

		return (List<Category>) resultqry.getResultList();
	}

	@Override
	public Category getCategoryById(long categoryId) {
		return entityManager.find(Category.class,  categoryId);
	}

	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);
		
	}

	@Override
	public void updateCategory(Category category) {
		Category cat = getCategoryById(category.getCategoryId());
		cat.setCategoryName(category.getCategoryName());
		
		entityManager.flush();
		
	}

	@Override
	public void deleteCategory(long categoryId) {
		entityManager.remove(getCategoryById(categoryId));
		
	}

	
	

}
