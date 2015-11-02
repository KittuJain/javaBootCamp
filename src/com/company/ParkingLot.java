package com.company;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private ParkingLotOwner parkingLotOwner;
    int receiptNumber = 0;
    Map<Receipt, Car> carReceipt = new HashMap<>();

    public ParkingLot(int capacity, ParkingLotOwner parkingLotOwner) {
        this.capacity = capacity;
        this.parkingLotOwner = parkingLotOwner;
    }

    private boolean isParkingSpaceAvailable() {
        return capacity > carReceipt.size();
    }

    private boolean isCarAlreadyParked(Car car) {
        return carReceipt.containsValue(car);
    }

    public Receipt park(Car car) throws ParkingSpaceFullException, CarAlreadyParkedException {
        if(isCarAlreadyParked(car))
            throw new CarAlreadyParkedException("Car is already parked");
        if(!isParkingSpaceAvailable())
            throw new ParkingSpaceFullException("No parking Space Available");
        receiptNumber++;
        Receipt receipt = new Receipt(receiptNumber); // Object receipt = new Object();
        carReceipt.put(receipt, car); // carReceipt.size() in receipt
        if(!isParkingSpaceAvailable())
            parkingLotOwner.notifyFullParking();
        return receipt;
    }

    public Car unPark(Receipt receipt) throws CarNotPresentException {
        if(carReceipt.containsKey(receipt)) {
            Car car = carReceipt.get(receipt);
            carReceipt.remove(receipt, car);
            return car;
        }
        throw new CarNotPresentException("Car is not present in ParkingLot");
    }
}
