package com.company;

public class ParkingLotOwner extends Owner {
    private boolean notifyFullParking = false;

    public void notifyFullParking() {
        this.notifyFullParking = true;
    }
}
