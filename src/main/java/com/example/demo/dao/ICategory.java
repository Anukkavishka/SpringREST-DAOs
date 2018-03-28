package com.example.demo.dao;

import java.util.List;

import com.example.demo.resources.Category;

public interface ICategory {
	
	List<Category> getAllCategories();
    Category getCategoryById(long categoryId);
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(long categoryId);
   
}
