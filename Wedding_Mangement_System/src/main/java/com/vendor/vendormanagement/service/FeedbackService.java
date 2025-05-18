package com.vendor.vendormanagement.service;


import com.vendor.vendormanagement.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FeedbackService {
    List<Feedback> getAllFeedback();
    Optional<Feedback> saveFeedback(Feedback feedback);
    Optional<Feedback> updateFeedback(int id, Feedback feedback);
    boolean deleteFeedback(int id);
    Optional<Feedback> findFeedbackById(int id);
    List<Feedback> findFeedbackByVendorId(int vendorId);
    List<Feedback> findFeedbackByClientId(int clientId);
}