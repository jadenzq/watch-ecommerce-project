package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String saveNewProduct(@ModelAttribute("productDto") ProductDto productDto,
			@RequestParam("image") ArrayList<MultipartFile> images) {
		
		// store image file
		ArrayList<String> imageFilenames = new ArrayList<>();		
		String imgUploadDir = "src/main/resources/static/images/";
		
		try {
			Path uploadPath = Paths.get(imgUploadDir);
			
			// create directory to store image
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			try {
				
				for(MultipartFile image : images) {
					imageFilenames.add(image.getOriginalFilename());
					InputStream inputStream = image.getInputStream();
					Files.copy(inputStream, Paths.get(imgUploadDir + image.getOriginalFilename()),
							StandardCopyOption.REPLACE_EXISTING);
				}

			} catch (Exception ex) {
				System.out.println("Exception: " + ex.getMessage());
			}
			
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		// copy inputs from form to a product instance
		Product product = new Product();
		product.setImgFilenames(imageFilenames);
		product.setCollection(productDto.getCollection());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setStock(productDto.getStock());
		product.setColour(productDto.getColour());
		product.setPlating(productDto.getPlating());
		product.setWeight(productDto.getWeight());
		
		// save product to database
		productService.saveNewProduct(product);
			
		return "redirect:/admin/products";
	}

	
	@GetMapping("/edit/product/{id}")
	public String editProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "edit_product";
	}
	
	
	@PostMapping("/update/product/{id}")
	public String updateProduct(
			@PathVariable("id") Long id,
			@ModelAttribute("product") Product product,
			@RequestParam("image1") MultipartFile image1,
			@RequestParam("image2") MultipartFile image2,
			@RequestParam("image3") MultipartFile image3,
			@RequestParam("image4") MultipartFile image4) {
		
		// retrieve the existing product
		Product oldProduct = productService.getProductById(id);
		// store image file
		ArrayList<String> oldImageFilenames = oldProduct.getImgFilenames();
		ArrayList<MultipartFile> imgFiles  = new ArrayList<>();
		
		// appending image files into a list
		imgFiles.add(image1);
		imgFiles.add(image2);
		imgFiles.add(image3);
		imgFiles.add(image4);
		
		
		String imgUploadDir = "src/main/resources/static/images/";
		
		try {
			Path uploadPath = Paths.get(imgUploadDir);
			// create directory to store image
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			try {
				
				for(int i=0; i<4; i++) { // loops 4 times to loop through all image inputs
					MultipartFile image = imgFiles.get(i);
					// if there contains image in any of the image inputs
					// delete old image files and update imgFilenames
					if (!image.isEmpty()) {
						InputStream inputStream = image.getInputStream();
						Files.copy(inputStream, Paths.get(imgUploadDir + image.getOriginalFilename()),
								StandardCopyOption.REPLACE_EXISTING);
						// delete old image file
						Files.deleteIfExists(Paths.get(imgUploadDir + oldImageFilenames.get(i)));
						// replace old image filename with new filename
						oldImageFilenames.remove(i);
						oldImageFilenames.add(i, image.getOriginalFilename());
					}
				}
			} catch (Exception ex) {
				System.out.println("Exception: " + ex.getMessage());
			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		// update image filenames and other properties
		oldProduct.setImgFilenames(oldImageFilenames);
		oldProduct.setId(id);
		oldProduct.setCollection(product.getCollection());
		oldProduct.setColour(product.getColour());
		oldProduct.setDescription(product.getDescription());
		oldProduct.setPlating(product.getPlating());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setStock(product.getStock());
		oldProduct.setWeight(product.getWeight());
		
		// save product to database
		productService.updateProduct(oldProduct);
			
		return "redirect:/admin/products";
	}
	
	
	@GetMapping("/delete/product/{id}")
	public String deleteProduct(@PathVariable("id") Long id ) throws IOException {
		
		Product product = productService.getProductById(id);
		ArrayList<String> imgFilenames = product.getImgFilenames();
		String imgUploadDir = "src/main/resources/static/images/";
		// delete the images
		for (String imgFilename : imgFilenames) {
			Files.deleteIfExists(Paths.get(imgUploadDir + imgFilename));
		}
		// delete the product from database
		productService.deleteProductById(id);
		return "redirect:/admin/products";
	}
}
