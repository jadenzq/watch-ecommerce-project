package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	// to implement the business logics
	private ProductService productService;
	
	// constructor
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping(path="/products")
	public String listAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
}
