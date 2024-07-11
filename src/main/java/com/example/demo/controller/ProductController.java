package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/products")
	public String listAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@GetMapping("/product/detail/{id}")
	public String showProductDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("currentProduct", productService.getProductById(id));
		model.addAttribute("products", productService.getAllProducts());
		return "product_details";
	}
	
}
