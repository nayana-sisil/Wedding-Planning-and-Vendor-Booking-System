package com.vendor.vendormanagement.model;

//

public class Vendor {

    private int id;
    private String name;
    private String serviceType;
    private double price;
    private String contact;
    private String district;
    private String country;
    private Double travelCost;

    //

    public Vendor() {}

    //

    public Vendor(int id, String name, String serviceType, double price, String contact) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.price = price;
        this.contact = contact;
    }

    //

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

    //

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    //

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    //

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    //

    public Double getTravelCost() { return travelCost; }
    public void setTravelCost(Double travelCost) { this.travelCost = travelCost; }



}
