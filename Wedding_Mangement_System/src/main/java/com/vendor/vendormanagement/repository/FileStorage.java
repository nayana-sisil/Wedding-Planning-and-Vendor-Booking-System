package com.vendor.vendormanagement.repository;


import com.vendor.vendormanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStorage {
    private final List<User> users = new ArrayList<>();

    public List<User> readUsers() {
        return new ArrayList<>(users);
    }

    public void writeUsers(List<User> updatedUsers) {
        users.clear();
        users.addAll(updatedUsers);
    }

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}