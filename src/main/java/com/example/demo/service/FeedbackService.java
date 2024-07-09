package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Feedback;

public interface FeedbackService {
	Feedback saveFeedback(Feedback feedback);
	List<Feedback> getAllFeedbacks();
	Feedback updateFeedbackStatus(Long id, String status);
}
