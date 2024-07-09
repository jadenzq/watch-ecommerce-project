package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import com.example.demo.entity.Feedback;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	private final FeedbackRepository feedbackRepository;
	
	@Autowired 
	public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}
	
    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
    	// sort feedbacks by date
        return feedbackRepository.findAll().stream()
            .sorted((f1, f2) -> {
                int statusComparison = f1.getStatus().compareTo(f2.getStatus());
                return statusComparison == 0 ? f1.getSubmissionDate().compareTo(f2.getSubmissionDate()) : statusComparison;
            })
            .collect(Collectors.toList());
    }
    
    @Override
    public Feedback updateFeedbackStatus(Long id, String status) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid feedback Id:" + id));
        feedback.setStatus(status);
        return feedbackRepository.save(feedback);
    }
}
