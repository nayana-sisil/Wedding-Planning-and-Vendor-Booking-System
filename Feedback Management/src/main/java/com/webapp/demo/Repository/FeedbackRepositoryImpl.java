package com.webapp.demo.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.webapp.demo.Model.Feedback;
import com.webapp.demo.Model.VerifiedFeedback;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {
    private static final String FILE_PATH = "feedback.txt";
    private final ObjectMapper objectMapper;

    public FeedbackRepositoryImpl() {
        this.objectMapper = configureObjectMapper();
    }

    @Override
    public List<Feedback> getAllFeedback() {
        File file = new File(FILE_PATH);
        List<Feedback> feedback = new ArrayList<>();

        try {
            if (file.exists() && file.length() > 0) {
                feedback = objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Feedback.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return feedback;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        List<Feedback> feedbackList = getAllFeedback();
        
        // Ensure the ID is unique
        int maxId = 0;
        for (Feedback existingFeedback : feedbackList) {
            if (existingFeedback.getId() > maxId) {
                maxId = existingFeedback.getId();
            }
        }
        feedback.setId(maxId + 1);
        
        feedbackList.add(feedback);

        try {
            objectMapper.writeValue(new File(FILE_PATH), feedbackList);
            return feedback;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Feedback updateFeedback(int id, Feedback feedback) {
        List<Feedback> feedbackList = getAllFeedback();
        for (int i = 0; i < feedbackList.size(); i++) {
            Feedback existingFeedback = feedbackList.get(i);
            if (existingFeedback.getId() == id) {
                feedback.setId(id); // Ensure ID remains the same
                feedbackList.set(i, feedback);
                try {
                    objectMapper.writeValue(new File(FILE_PATH), feedbackList);
                    return feedback;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteFeedback(int id) {
        List<Feedback> feedbackList = getAllFeedback();
        Feedback toRemove = null;

        for (Feedback feedback : feedbackList) {
            if (feedback.getId() == id) {
                toRemove = feedback;
                break;
            }
        }

        if (toRemove != null) {
            feedbackList.remove(toRemove);
            try {
                objectMapper.writeValue(new File(FILE_PATH), feedbackList);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public Feedback findFeedbackById(int id) {
        List<Feedback> feedbackList = getAllFeedback();
        for (Feedback feedback : feedbackList) {
            if (feedback.getId() == id) {
                return feedback;
            }
        }
        return null;
    }

    @Override
    public List<Feedback> findFeedbackByVendorId(int vendorId) {
        List<Feedback> feedbackList = getAllFeedback();
        return feedbackList.stream()
                .filter(feedback -> feedback.getVendorId() == vendorId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Feedback> findFeedbackByClientId(int clientId) {
        List<Feedback> feedbackList = getAllFeedback();
        return feedbackList.stream()
                .filter(feedback -> feedback.getClientId() == clientId)
                .collect(Collectors.toList());
    }

    private ObjectMapper configureObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }
}