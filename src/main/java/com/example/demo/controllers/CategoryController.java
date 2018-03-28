package com.example.demo.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resources.Category;
import com.example.demo.service.CategoryDAoService;

@RestController
public class CategoryController {


@Autowired	
private CategoryDAoService category_dao_service;

@RequestMapping("/categories")
public List<Category> getAllCategory(){
	return category_dao_service.getAllCategory();
	
}

@RequestMapping("/categories/{id}")
public Category getCategory(@PathVariable long id) {

	return category_dao_service.getCategoryById(id);
}

@RequestMapping(method=RequestMethod.POST,value="/categories")
public void addCategory(@RequestBody Category category) {
	
	category_dao_service.addCategory(category);
}

@RequestMapping(method=RequestMethod.PUT,value="/categories/{id}")
public void updateCategory(@RequestBody Category category,@PathVariable long id) {
	category_dao_service.updateCategory(category);
}

@RequestMapping(method=RequestMethod.DELETE,value="/categories/{id}")
public void deleteCategory(@PathVariable long id) {
	category_dao_service.deleteCategory(id);;
}



}
