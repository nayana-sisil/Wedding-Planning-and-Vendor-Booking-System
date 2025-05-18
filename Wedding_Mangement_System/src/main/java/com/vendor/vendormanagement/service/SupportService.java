package com.vendor.vendormanagement.service;



import com.vendor.vendormanagement.model.Support;
import com.vendor.vendormanagement.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportService {

    @Autowired
    private SupportRepository supportRepository;

    public void submitSupportRequest(Support support) {
        supportRepository.save(support);
    }

    public List<Support> getAllSupportRequests() {
        return supportRepository.findAll();  // already safe
    }

    // Optional if using filtered view
    public List<Support> getSupportByFilter(String input) {
        return supportRepository.findByIdFilter(input);  // input-safe method
    }
}
