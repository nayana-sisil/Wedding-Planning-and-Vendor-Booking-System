package com.vendor.vendormanagement.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.annotation.Inherited;
import java.time.LocalDate;


public class Wedding {

    protected int clientId;

    protected String groomName;

    protected String brideName;

    protected LocalDate weddingDate;

    protected int guestCount;

    //


    public Wedding() {
    }

    public Wedding(int clientId, String groomName, String brideName, LocalDate weddingDate, int guestCount) {
        this.clientId = clientId;
        this.groomName = groomName;
        this.brideName = brideName;
        this.weddingDate = weddingDate;
        this.guestCount = guestCount;
    }

    //


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getGroomName() {
        return groomName;
    }

    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(LocalDate weddingDate) {
        this.weddingDate = weddingDate;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }
}
