package com.webapp.demo.Model;

import java.time.LocalDate;

public class Feedback {
    protected int id;
    protected int clientId;
    protected int vendorId;
    protected int rating;
    protected String comment;
    protected LocalDate reviewDate;

    public Feedback() {
    }

    public Feedback(int id, int clientId, int vendorId, int rating, String comment, LocalDate reviewDate) {
        this.id = id;
        this.clientId = clientId;
        this.vendorId = vendorId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}