package com.vendor.vendormanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String weddingDate;
    private String partnerName;
    private String adminLevel;

    public User() {}

    public User(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @JsonProperty("id")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @JsonProperty("username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonProperty("email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @JsonProperty("password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @JsonProperty("role")
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @JsonProperty("weddingDate")
    public String getWeddingDate() { return weddingDate; }
    public void setWeddingDate(String weddingDate) { this.weddingDate = weddingDate; }

    @JsonProperty("partnerName")
    public String getPartnerName() { return partnerName; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }

    @JsonProperty("adminLevel")
    public String getAdminLevel() { return adminLevel; }
    public void setAdminLevel(String adminLevel) { this.adminLevel = adminLevel; }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", weddingDate='" + weddingDate + '\'' +
                ", partnerName='" + partnerName + '\'' +
                ", adminLevel='" + adminLevel + '\'' +
                '}';
    }
}