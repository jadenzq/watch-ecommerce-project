package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class ReviewController {

		private ReviewService reviewService;
		private ProductService productService;
		
		public ReviewController(ReviewService reviewService, ProductService productService) {
			super();
			this.reviewService = reviewService;
			this.productService = productService;
		}
		
		@GetMapping("/product/{productId}")
		public String listReview(@PathVariable Long productId, Model model) {
			Product product = productService.getProductById(productId);
			model.addAttribute("reviews", reviewService.findByProduct(product));
			model.addAttribute("averageRating", reviewService.getAverageRating());
			model.addAttribute("review", new Review());
			model.addAttribute("reviewDate", reviewService.getCurrentTime());
			return "product";
		}
		
		@PostMapping("/product/{productId}")
		public String saveReview(@PathVariable Long productId, @ModelAttribute("review") Review review) {
			Product product = productService.getProductById(productId);
	        review.setProduct(product);
	        reviewService.saveReview(review);
	        return "redirect:/product/{productId}";
		}
		
		@GetMapping("/userReview")
		public String listUserReview(Model model) {
			model.addAttribute("reviews", reviewService.getAllReviews());
			return "user_review";
		}
}
