package com.example.demo.controller;

import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    
    public FeedbackController(FeedbackService feedbackService) {
    	super();
    	this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback/form") // Enter this URL to view form  
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback"; // display feedback.html page
    }
    

    // After submitting the form, return a parameter indicating success. The pop-up window will show up
    @PostMapping("/feedback")
    public String createFeedback(@ModelAttribute Feedback feedback, RedirectAttributes redirectAttributes) {
        feedbackService.saveFeedback(feedback);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/feedback/form?success";
    }


    @GetMapping("/feedbacklist_admin") // this is for visit feedback list
    public String listFeedback(Model model) {
        List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
        model.addAttribute("feedback_list", feedbackList);
        return "feedbacklist_admin";
    }
    
    // This is for updating the status
    @PostMapping("/feedback/{id}/updateStatus")
    public String updateFeedbackStatus(@PathVariable Long id, @RequestParam String status) {
        feedbackService.updateFeedbackStatus(id, status);
        return "redirect:/feedbacklist_admin";
    }
    
}
