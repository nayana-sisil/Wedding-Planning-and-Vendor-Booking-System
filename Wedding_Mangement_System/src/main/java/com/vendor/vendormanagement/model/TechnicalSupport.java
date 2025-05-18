package com.vendor.vendormanagement.model;

public class TechnicalSupport extends Support {
    public TechnicalSupport(int id, String customerName, String message) {
        super(id, customerName, "Technical", message);
    }
}