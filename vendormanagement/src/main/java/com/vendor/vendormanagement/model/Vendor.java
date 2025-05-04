package com.vendor.vendormanagement.model;

import jakarta.persistence.Entity;

@Entity
public class Vendor {

    private int id;
    private String name;
    private String serviceTyp;

    public int getIdd() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamee() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServicetype() {
        return serviceTyp;
    }

    public void setServicetype(String serviceTyp) {
        this.serviceTyp = serviceTyp;
    }
}
