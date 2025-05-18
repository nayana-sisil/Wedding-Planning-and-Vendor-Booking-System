package com.WeddingPlanning.demo.repository;

import com.WeddingPlanning.demo.entity.User;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStorage {
    private final List<User> users = new ArrayList<>();
    private final String FILE_PATH = "users.txt";

    public FileStorage() {
        // Load existing users from file when the application starts
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            // First check if file is empty or contains invalid data
            try (BufferedReader checkReader = new BufferedReader(new FileReader(file))) {
                String firstLine = checkReader.readLine();
                if (firstLine == null || firstLine.trim().equals("[]%")) {
                    System.out.println("Users file is empty or contains invalid data. Starting with empty user list.");
                    return;
                }
            } catch (IOException e) {
                System.err.println("Error checking users.txt content: " + e.getMessage());
                e.printStackTrace();
                return;
            }

            // Now read the file for user data
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                User currentUser = null;

                while ((line = reader.readLine()) != null) {
                    // Skip empty lines or separator
                    if (line.trim().isEmpty() || line.contains("----------")) {
                        if (currentUser != null) {
                            users.add(currentUser);
                            currentUser = null;
                        }
                        continue;
                    }

                    // Parse user data
                    if (line.startsWith("ID: ")) {
                        // Start of a new user
                        currentUser = new User();
                        currentUser.setId(line.substring(4).trim());
                    } else if (currentUser != null) {
                        if (line.startsWith("Username: ")) {
                            currentUser.setUsername(line.substring(10).trim());
                        } else if (line.startsWith("Email: ")) {
                            currentUser.setEmail(line.substring(7).trim());
                        } else if (line.startsWith("Role: ")) {
                            currentUser.setRole(line.substring(6).trim());
                        } else if (line.startsWith("Wedding Date: ")) {
                            currentUser.setWeddingDate(line.substring(14).trim());
                        } else if (line.startsWith("Partner Name: ")) {
                            currentUser.setPartnerName(line.substring(14).trim());
                        } else if (line.startsWith("Admin Level: ")) {
                            currentUser.setAdminLevel(line.substring(13).trim());
                        } else if (line.startsWith("Password: ")) {
                            currentUser.setPassword(line.substring(10).trim());
                        }
                    }
                }

                // Add the last user if there is one
                if (currentUser != null) {
                    users.add(currentUser);
                }

                System.out.println("Loaded " + users.size() + " users from file: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error reading from users.txt: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Users file does not exist. Will create when users are added.");
        }
    }

    public List<User> readUsers() {
        return new ArrayList<>(users);
    }

    public void writeUsers(List<User> updatedUsers) {
        users.clear();
        users.addAll(updatedUsers);

        // Create the file if it doesn't exist, or truncate it if it does
        File file = new File(FILE_PATH);
        try {
            // Make sure the file exists and is empty
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Created new users.txt file");
            } else {
                // Truncate the file by opening it with FileOutputStream
                new FileOutputStream(file).close();
                System.out.println("Truncated existing users.txt file");
            }
        } catch (IOException e) {
            System.err.println("Error creating/truncating users.txt file: " + e.getMessage());
            e.printStackTrace();
            return; // Return early if we can't create/truncate the file
        }

        // Write to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) { // false to overwrite
            for (User user : updatedUsers) {
                writer.write("ID: " + user.getId());
                writer.newLine();
                writer.write("Username: " + user.getUsername());
                writer.newLine();
                writer.write("Email: " + user.getEmail());
                writer.newLine();
                writer.write("Password: " + user.getPassword());
                writer.newLine();
                writer.write("Role: " + user.getRole());
                writer.newLine();

                // Write client-specific fields if present
                if (user.getWeddingDate() != null && !user.getWeddingDate().isEmpty()) {
                    writer.write("Wedding Date: " + user.getWeddingDate());
                    writer.newLine();
                }
                if (user.getPartnerName() != null && !user.getPartnerName().isEmpty()) {
                    writer.write("Partner Name: " + user.getPartnerName());
                    writer.newLine();
                }

                // Write admin-specific fields if present
                if (user.getAdminLevel() != null && !user.getAdminLevel().isEmpty()) {
                    writer.write("Admin Level: " + user.getAdminLevel());
                    writer.newLine();
                }

                // Add a separator between users
                writer.write("------------------------------");
                writer.newLine();
            }
            System.out.println("Saved " + updatedUsers.size() + " users to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing to users.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
