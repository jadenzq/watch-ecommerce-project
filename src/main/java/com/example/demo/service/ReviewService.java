package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.Review;

public interface ReviewService {
	List<Review> getAllReviews();
	
	double getAverageRating();
	
	LocalDateTime getCurrentTime();
	
	Review saveReview(Review review);
}
