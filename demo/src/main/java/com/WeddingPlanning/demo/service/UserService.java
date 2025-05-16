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
}