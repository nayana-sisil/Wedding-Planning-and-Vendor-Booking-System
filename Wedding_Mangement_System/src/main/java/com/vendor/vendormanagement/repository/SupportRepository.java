package com.vendor.vendormanagement.repository;

import com.vendor.vendormanagement.model.Support;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class SupportRepository {

    private final List<Support> supportRequests = new ArrayList<>();

    public void save(Support support) {
        supportRequests.add(support);
    }

    public List<Support> findAll() {
        return new ArrayList<>(supportRequests);
    }

    public List<Support> findByIdFilter(String input) {
        if (input == null || input.trim().isEmpty()) {
            return findAll();
        }

        try {
            int id = Integer.parseInt(input.trim());
            List<Support> filtered = new ArrayList<>();
            for (Support support : supportRequests) {
                if (support.getId() == id) {
                    filtered.add(support);
                }
            }
            return filtered;
        } catch (NumberFormatException e) {
            System.err.println("Invalid ID: " + input);
            return Collections.emptyList();
        }
    }
}
