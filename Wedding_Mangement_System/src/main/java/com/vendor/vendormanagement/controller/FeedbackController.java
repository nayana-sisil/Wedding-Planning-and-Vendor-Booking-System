package com.vendor.vendormanagement.controller;


import com.vendor.vendormanagement.model.Feedback;
import com.vendor.vendormanagement.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // GET all feedback
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.getAllFeedback();
    }

    // GET feedback by ID
    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable int id) {
        return feedbackRepository.findFeedbackById(id);
    }

    // GET feedback by vendor ID
    @GetMapping("/vendor/{vendorId}")
    public List<Feedback> getFeedbackByVendorId(@PathVariable int vendorId) {
        return feedbackRepository.findFeedbackByVendorId(vendorId);
    }

    // GET feedback by client ID
    @GetMapping("/client/{clientId}")
    public List<Feedback> getFeedbackByClientId(@PathVariable int clientId) {
        return feedbackRepository.findFeedbackByClientId(clientId);
    }

    // POST - create new feedback
    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackRepository.saveFeedback(feedback);
    }

    // PUT - update existing feedback
    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
        return feedbackRepository.updateFeedback(id, feedback);
    }

    // DELETE - delete feedback by ID
    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable int id) {
        boolean deleted = feedbackRepository.deleteFeedback(id);
        if (deleted) {
            return "Feedback with ID " + id + " was deleted.";
        } else {
            return "Feedback not found.";
        }
    }
}
