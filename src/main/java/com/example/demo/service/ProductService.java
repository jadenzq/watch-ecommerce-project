package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long id);
	
	void updateProduct(Product product);
	
	void updateAllProducts(List<Product> products);
	
	void addNewProduct(Product product);
	
	void deleteProductById(Long id);
}
