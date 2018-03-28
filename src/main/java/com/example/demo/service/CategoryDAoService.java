package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICategory;
import com.example.demo.resources.Category;

@Transactional
@Service
public class CategoryDAoService {

	

	
	public CategoryDAoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ICategory categoryDAO;

	public Category getCategoryById(long categoryId) {
		Category obj = categoryDAO.getCategoryById(categoryId);
		return obj;
	}	
	
	public List<Category > getAllCategory(){
		return categoryDAO.getAllCategories();
	}

	public synchronized void addCategory(Category  category){
        categoryDAO.addCategory (category);
    	        
	}
	
	public void updateCategory(Category  category) {
		categoryDAO.updateCategory(category);
	}
	
	public void deleteCategory(long categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}
	


}
