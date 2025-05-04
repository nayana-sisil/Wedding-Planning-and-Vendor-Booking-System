package com.vendor.vendormanagement.model;

public class Vendor {
    private int id;
    private String name;
    private String serviceType;
    private double price;

    public Vendor() {}

    // default constructor

    public Vendor(int id, String name, String serviceType, double price) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.price = price;
    }

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    //

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    //

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
