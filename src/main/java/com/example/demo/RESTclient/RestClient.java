package com.example.demo.RESTclient;



import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.product.Product;

public class RestClient {
    public void getProductByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/products/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product.class, 1);
        Product product = responseEntity.getBody();
        System.out.println("Id:"+product.getProductId()+", Title:"+product.getProductName()
                 +", Selling Price:"+product.getSellingPrice());      
    }
    public void getAllProductsDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/products";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product[].class);
        Product[] products = responseEntity.getBody();
        for(Product product : products) {
        	System.out.println("Id:"+product.getProductId()+", Title:"+product.getProductName()
            +", Selling Price:"+product.getSellingPrice());
        }
    }
    public void addProductDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/products";
        Product objProduct = new Product();
        objProduct.setProductName("Mango");
        objProduct.setBuyingPrice(1900);
        objProduct.setIsService(false);
        objProduct.setSellingPrice(9000);
        objProduct.setReorderLevel(9);
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(objProduct, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateProductDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/products";
        Product objProduct = new Product();
        objProduct.setProductName("Pine Apple");
        objProduct.setBuyingPrice(900);
        objProduct.setIsService(false);
        objProduct.setSellingPrice(3000);
        objProduct.setReorderLevel(7);
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(objProduct, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/products/{id}";
        HttpEntity<Product> requestEntity = new HttpEntity<Product>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClient util = new RestClient();
        //util.getArticleByIdDemo();
    	util.getAllProductsDemo();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    }   
    
    
}
