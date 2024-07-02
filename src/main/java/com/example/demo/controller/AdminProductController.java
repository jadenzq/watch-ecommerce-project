package com.example.demo.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDto;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	
	// to implement the business logics
	private ProductService productService;
	
	// constructor
	public AdminProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	

	@GetMapping("/products")
	public String listAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "admin_products";
	}
	
	// create an empty product instance and store inside model
	@GetMapping("/add/product")
	public String addNewProduct(Model model) {
		ProductDto productDto = new ProductDto();
		model.addAttribute("productDto", productDto);
		return "add_product";
	}
	
	// saveNewProduct(@ModelAttribute Product product){productService.save(model)}
	@PostMapping("/save/product")
	public String saveNewProduct(@ModelAttribute("productDto") ProductDto productDto) {
		
		// store image file
		MultipartFile image = productDto.getImgFile();
		String storageFileName = image.getOriginalFilename();
		String imgDir = "/public/images/";
		
		
		try {
			Path uploadPath = Paths.get(imgDir);
			
			// create directory to store image
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			try (InputStream inputStream = image.getInputStream()){
				Files.copy(inputStream, Paths.get(imgDir + storageFileName),
						StandardCopyOption.REPLACE_EXISTING);
			}
			
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		// copy inputs from form to a product instance
		Product product = new Product();
		product.setImgUrl(imgDir + storageFileName);
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setStock(productDto.getStock());
		product.setCollection(productDto.getCollection());
		product.setColour(productDto.getColour());
		product.setPlating(productDto.getPlating());
		product.setWeight(productDto.getWeight());
		
		// save product to database
		productService.saveNewProduct(product);
			
		return "redirect:/admin/products";
	}
}
