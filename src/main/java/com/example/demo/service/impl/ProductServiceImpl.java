package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	// to utilize JpaRepository query commands
	private ProductRepository productRepo;
	
	// constructor
	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}


	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepo.findAll(); 
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		Product product = productRepo.getReferenceById(id);
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public void updateAllProducts(List<Product> products) {
		productRepo.saveAll(products);
	}

	@Override
	public void addNewProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		productRepo.deleteById(id);
	}
	
}
