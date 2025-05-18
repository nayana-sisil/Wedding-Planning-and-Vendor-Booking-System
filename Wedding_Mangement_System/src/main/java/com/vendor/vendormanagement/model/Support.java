package com.vendor.vendormanagement.model;

public class Support {

    private int id;
    private String customerName;
    private String type;
    private String message;

    // ✅ No-arg constructor (required by Spring)
    public Support() {
    }

    // ✅ All-arg constructor
    public Support(int id, String customerName, String type, String message) {
        this.id = id;
        this.customerName = customerName;
        this.type = type;
        this.message = message;
    }

    // ✅ Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

