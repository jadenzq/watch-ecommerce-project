package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;

@Controller
public class ReviewController {

		private ReviewService reviewService;
		
		public ReviewController(ReviewService reviewService) {
			super();
			this.reviewService = reviewService;
		}
		
		@GetMapping("/product")
		public String listReview(Model model) {
			model.addAttribute("reviews", reviewService.getAllReviews());
			model.addAttribute("averageRating", reviewService.getAverageRating());
			model.addAttribute("review", new Review());
			model.addAttribute("reviewDate", reviewService.getCurrentTime());
			return "product";
		}
		
		@PostMapping("/product")
		public String saveReview(@ModelAttribute("review") Review review) {
		    reviewService.saveReview(review);
		    return "redirect:/product";
		}
		
		@GetMapping("/userReview")
		public String listUserReview(Model model) {
			model.addAttribute("reviews", reviewService.getAllReviews());
			return "user_review";
		}
}
