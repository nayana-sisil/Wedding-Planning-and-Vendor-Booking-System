package com.webapp.demo.Model;

import java.time.LocalDate;

public class VerifiedFeedback extends Feedback {
    private boolean isVerified;
    private LocalDate verificationDate;
    private String adminComments;

    public VerifiedFeedback() {
    }

    public VerifiedFeedback(int id, int clientId, int vendorId, int rating, String comment, LocalDate reviewDate,
                           boolean isVerified, LocalDate verificationDate, String adminComments) {
        super(id, clientId, vendorId, rating, comment, reviewDate);
        this.isVerified = isVerified;
        this.verificationDate = verificationDate;
        this.adminComments = adminComments;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public LocalDate getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getAdminComments() {
        return adminComments;
    }

    public void setAdminComments(String adminComments) {
        this.adminComments = adminComments;
    }
}