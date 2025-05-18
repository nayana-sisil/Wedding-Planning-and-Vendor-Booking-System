package com.vendor.vendormanagement.model;

public class BillingSupport extends Support {
    public BillingSupport(int id, String customerName, String message) {
        super(id, customerName, "Billing", message);
    }
}