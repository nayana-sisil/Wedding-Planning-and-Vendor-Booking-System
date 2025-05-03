package com.webapp.demo.Model;

import java.time.LocalDate;

public class OutdoorWedding extends Wedding {

    private boolean tentRequired;

    private boolean parkingAvailable;

    //


    public OutdoorWedding() {
    }

    public OutdoorWedding(int clientId, String groomName, String brideName, LocalDate weddingDate, int guestCount
    , boolean tentRequired, boolean parkingAvailable) {
        super(clientId, groomName, brideName, weddingDate, guestCount);
        this.tentRequired = tentRequired;
        this.parkingAvailable = parkingAvailable;
    }

    //


    public boolean isTentRequired() {
        return tentRequired;
    }

    public void setTentRequired(boolean tentRequired) {
        this.tentRequired = tentRequired;
    }

    public boolean isParkingAvailable() {
        return parkingAvailable;
    }

    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }
}
