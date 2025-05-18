package com.webapp.demo.Repository;

import com.webapp.demo.Model.Feedback;
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