package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")

public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	
	@Column(name="rating", nullable=false)
	private int rating;
	
	@Column(name="reviewContent", nullable=true)
	private String reviewContent;
	
	@Column(name="reviewDatetime", nullable=false)
	private LocalDateTime reviewDatetime;

	public Review() {}
	
	public Review(int rating, String reviewContent, LocalDateTime reviewDatetime) {
		super();
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.reviewDatetime = reviewDatetime;
	}
	
	public Long getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getReviewContent() {
		return reviewContent;
	}
	
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
	public LocalDateTime getReviewDatetime() {
		return reviewDatetime;
	}
	
	public void setReviewDatetime(LocalDateTime reviewDatetime) {
		this.reviewDatetime = reviewDatetime;
	}

}