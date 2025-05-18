package com.vendor.vendormanagement.model;

import java.time.LocalDate;

public class Booking {
    private int id;
    private int weddingId;
    private int vendorId;
    private LocalDate bookingDate;
    private LocalDate serviceDate;
    private double cost;
    private String status;
    private String notes;

    public Booking() {
    }

    public Booking(int id, int weddingId, int vendorId, LocalDate bookingDate, LocalDate serviceDate,
                   double cost, String status, String notes) {
        this.id = id;
        this.weddingId = weddingId;
        this.vendorId = vendorId;
        this.bookingDate = bookingDate;
        this.serviceDate = serviceDate;
        this.cost = cost;
        this.status = status;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeddingId() {
        return weddingId;
    }

    public void setWeddingId(int weddingId) {
        this.weddingId = weddingId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}