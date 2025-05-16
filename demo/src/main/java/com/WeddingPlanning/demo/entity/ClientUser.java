package com.WeddingPlanning.demo.entity;

public class ClientUser extends User {
    private String weddingDate;
    private String partnerName;
    private int guestCount;

    public ClientUser() {
        setRole("clients");
    }

    public ClientUser(String username, String email, String password, String weddingDate, String partnerName, int guestCount) {
        super(username, email, password, "clients");
        this.weddingDate = weddingDate;
        this.partnerName = partnerName;
        this.guestCount = guestCount;
    }

    public String getWeddingDate() { return weddingDate; }
    public void setWeddingDate(String weddingDate) { this.weddingDate = weddingDate; }
    public String getPartnerName() { return partnerName; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }
    public int getGuestCount() { return guestCount; }
    public void setGuestCount(int guestCount) { this.guestCount = guestCount; }
}