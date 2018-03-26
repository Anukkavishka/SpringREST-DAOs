package com.example.demo.product;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDAoService;

@RestController
public class ProductController {


@Autowired	
private ProductDAoService product_dao_service;

@RequestMapping("/products")
public List<Product> getAllProducts(){
	return product_dao_service.getAllProducts();
	
}

@RequestMapping("/products/{id}")
public Product getProduct(@PathVariable long id) {

	return product_dao_service.getProductById(id);
}

@RequestMapping(method=RequestMethod.POST,value="/products")
public void addProduct(@RequestBody Product product) {
	
	product_dao_service.addProduct(product);
}

@RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
public void updateProduct(@RequestBody Product product,@PathVariable long id) {
	product_dao_service.updateProduct(product);
}

@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
public void deleteProduct(@PathVariable long id) {
	product_dao_service.deleteProduct(id);
}



}
