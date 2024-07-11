
package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewRepository reviewRepo;
	
	public ReviewServiceImpl(ReviewRepository reviewRepo) {
		super();
		this.reviewRepo = reviewRepo;
	}

	@Override
	public List<Review> getAllReviews(){
		return reviewRepo.findAll();
	}
	
	@Override
	public double getAverageRating() {
		List<Review> reviews = reviewRepo.findAll();
		double average = reviews.stream()
		                        .mapToInt(Review::getRating)
		                        .average()
		                        .orElse(0.0);
		BigDecimal bd = BigDecimal.valueOf(average);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	@Override
	public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();  
	}
	
	@Override
	public Review saveReview(Review review){
		  if (review.getReviewDatetime() == null) {
	            review.setReviewDatetime(getCurrentTime()); // Use getCurrentTime() method
	        }
		return reviewRepo.save(review);
	}
}