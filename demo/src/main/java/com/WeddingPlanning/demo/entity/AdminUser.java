package com.WeddingPlanning.demo.entity;

public class AdminUser extends User {
    private String adminLevel;

    public AdminUser() {
        setRole("admins");
    }

    public AdminUser(String username, String email, String password, String adminLevel) {
        super(username, email, password, "admins");
        this.adminLevel = adminLevel;
    }

    public String getAdminLevel() { return adminLevel; }
    public void setAdminLevel(String adminLevel) { this.adminLevel = adminLevel; }
}
