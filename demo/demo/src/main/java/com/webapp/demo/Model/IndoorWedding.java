package com.webapp.demo.Model;

import java.time.LocalDate;

public class IndoorWedding extends Wedding {

    private boolean acAvailable;

    private boolean kitchenAccess;

//

    public IndoorWedding(int clientId, String groomName, String brideName, LocalDate weddingDate, int guestCount
    , Boolean acAvailable, boolean kitchenAccess) {
        super(clientId, groomName, brideName, weddingDate, guestCount);
        this.acAvailable = acAvailable;
        this.kitchenAccess = kitchenAccess;
    }

    //


    public boolean isAcAvailable() {
        return acAvailable;
    }

    public void setAcAvailable(boolean acAvailable) {
        this.acAvailable = acAvailable;
    }

    public boolean isKitchenAccess() {
        return kitchenAccess;
    }

    public void setKitchenAccess(boolean kitchenAccess) {
        this.kitchenAccess = kitchenAccess;
    }
}
