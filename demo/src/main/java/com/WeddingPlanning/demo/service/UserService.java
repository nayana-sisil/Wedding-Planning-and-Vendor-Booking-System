package com.WeddingPlanning.demo.service;

import com.WeddingPlanning.demo.entity.User;
import com.WeddingPlanning.demo.repository.FileStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final FileStorage fileStorageUtil;

    public UserService(FileStorage fileStorageUtil) {
        this.fileStorageUtil = fileStorageUtil;
    }

    public User createUser(User newUser) {
        List<User> users = fileStorageUtil.readUsers();
        if (users.stream().anyMatch(u -> u.getEmail().equals(newUser.getEmail()))) {
            throw new IllegalStateException("User with this email already exists");
        }
        newUser.setId(fileStorageUtil.generateId());
        users.add(newUser);
        fileStorageUtil.writeUsers(users);
        return newUser;
    }

    public List<User> getAllUsers() {
        return fileStorageUtil.readUsers();
    }

    public Optional<User> getUserById(String id) {
        return fileStorageUtil.readUsers().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public Optional<User> getUserByEmail(String email) {
        return fileStorageUtil.readUsers().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }

    public User updateUser(String id, User updatedUser) {
        List<User> users = fileStorageUtil.readUsers();
        Optional<User> existingUserOpt = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if (existingUserOpt.isEmpty()) {
            throw new IllegalStateException("User not found with id: " + id);
        }

        User existingUser = existingUserOpt.get();
        // Update user properties
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setWeddingDate(updatedUser.getWeddingDate());
        existingUser.setPartnerName(updatedUser.getPartnerName());
        existingUser.setAdminLevel(updatedUser.getAdminLevel());

        // Save updated list
        fileStorageUtil.writeUsers(users);
        return existingUser;
    }

    public void deleteUser(String id) {
        List<User> users = fileStorageUtil.readUsers();
        boolean removed = users.removeIf(u -> u.getId().equals(id));

        if (!removed) {
            throw new IllegalStateException("User not found with id: " + id);
        }

        fileStorageUtil.writeUsers(users);
    }
}
