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


//


class LocalVendor extends Vendor {
    private String district;

    public LocalVendor() {}

    //

    public LocalVendor(int id, String name, String serviceType, double price, String district) {
        super(id, name, serviceType, price);
        this.district = district;
    }

    //

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
}


//


class ExternalVendor extends Vendor {
    private String country;
    private double travelCost;

    public ExternalVendor() {}

    //

    public ExternalVendor(int id, String name, String serviceType, double price, String country, double travelCost) {
        super(id, name, serviceType, price);
        this.country = country;
        this.travelCost = travelCost;
    }

    //

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    //

    public double getTravelCost() { return travelCost; }
    public void setTravelCost(double travelCost) { this.travelCost = travelCost; }

    //

    public double getTotalPrice() {
        return getPrice() + travelCost;
    }
}
