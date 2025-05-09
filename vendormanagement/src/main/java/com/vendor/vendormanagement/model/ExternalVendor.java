package com.vendor.vendormanagement.model;

public class ExternalVendor extends Vendor {
    private String country;
    private double travelCost;

    public ExternalVendor() {}

    public ExternalVendor(int id, String name, String serviceType, double price, String contact, String country, double travelCost) {
        super(id, name, serviceType, price, contact);
        this.country = country;
        this.travelCost = travelCost;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTravelCost() {
        return travelCost;
    }

    public void setTravelCost(double travelCost) {
        this.travelCost = travelCost;
    }

    public double getTotalPrice() {
        return getPrice() + travelCost;
    }
}
