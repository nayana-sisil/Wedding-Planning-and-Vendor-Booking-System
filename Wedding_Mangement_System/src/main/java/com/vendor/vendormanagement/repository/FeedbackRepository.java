package com.vendor.vendormanagement.repository;

import com.vendor.vendormanagement.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository {
    List<Feedback> getAllFeedback();
    Feedback saveFeedback(Feedback feedback);
    Feedback updateFeedback(int id, Feedback feedback);
    boolean deleteFeedback(int id);
    Feedback findFeedbackById(int id);
    List<Feedback> findFeedbackByVendorId(int vendorId);
    List<Feedback> findFeedbackByClientId(int clientId);
}