package com.webapp.demo.Service;

import com.webapp.demo.Model.Feedback;
import com.webapp.demo.Repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.getAllFeedback();
    }

    @Override
    public Optional<Feedback> saveFeedback(Feedback feedback) {
        Feedback savedFeedback = feedbackRepository.saveFeedback(feedback);
        return Optional.ofNullable(savedFeedback);
    }

    @Override
    public Optional<Feedback> updateFeedback(int id, Feedback feedback) {
        Feedback updatedFeedback = feedbackRepository.updateFeedback(id, feedback);
        return Optional.ofNullable(updatedFeedback);
    }

    @Override
    public boolean deleteFeedback(int id) {
        return feedbackRepository.deleteFeedback(id);
    }

    @Override
    public Optional<Feedback> findFeedbackById(int id) {
        Feedback feedback = feedbackRepository.findFeedbackById(id);
        return Optional.ofNullable(feedback);
    }

    @Override
    public List<Feedback> findFeedbackByVendorId(int vendorId) {
        return feedbackRepository.findFeedbackByVendorId(vendorId);
    }

    @Override
    public List<Feedback> findFeedbackByClientId(int clientId) {
        return feedbackRepository.findFeedbackByClientId(clientId);
    }
}