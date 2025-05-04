package com.vendor.vendormanagement.model;

//

public class LocalVendor extends Vendor {
    private String district;

    //

    public LocalVendor() {
    }

    //

    public LocalVendor(int id, String name, String serviceType, double price, String district) {
        super(id, name, serviceType, price);
        this.district = district;
    }

    //

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
