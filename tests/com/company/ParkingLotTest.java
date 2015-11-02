package com.company;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTest {

    @Test
    public void parkShouldParkCarIfSpaceIsAvailableInParkingLot () throws ParkingSpaceFullException, CarAlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(20, new ParkingLotOwner());
        Car car = new Car("UP2561");
        assertEquals(new Receipt(1), parkingLot.park(car));
    }

    @Test(expected = ParkingSpaceFullException.class)
    public void parkShouldThrowErrorIfParkingSpaceIsFull () throws ParkingSpaceFullException, CarAlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2, new ParkingLotOwner());
        assertEquals(new Receipt(1), parkingLot.park(new Car("UP2541")));
        assertEquals(new Receipt(2), parkingLot.park(new Car("UP2551")));
        parkingLot.park(new Car("UP2561"));
    }

    @Test(expected = CarAlreadyParkedException.class)
    public void parkShouldThrowErrorIfCarIsAlreadyParked () throws ParkingSpaceFullException, CarAlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(10, new ParkingLotOwner());
        Car car = new Car("UP2561");
        assertEquals(new Receipt(1), parkingLot.park(car));
        parkingLot.park(car);
    }

    @Test
    public void unParkShouldUnParkCarWhenItIsParked () throws ParkingSpaceFullException, CarAlreadyParkedException, CarNotPresentException {
        ParkingLot parkingLot = new ParkingLot(20, new ParkingLotOwner());
        Car car = new Car("UP2561");
        Receipt receipt = new Receipt(1);
        assertEquals(receipt, parkingLot.park(car));
        assertEquals(car, parkingLot.unPark(receipt));
    }

    @Test(expected = CarNotPresentException.class)
    public void unParkShouldThrowErrorIfCarDoesNotExistInParkingLot () throws ParkingSpaceFullException, CarAlreadyParkedException, CarNotPresentException {
        ParkingLot parkingLot = new ParkingLot(20, new ParkingLotOwner());
        parkingLot.unPark(new Receipt(1));
    }

    @Mock
    ParkingLotOwner parkingLotOwner;

    @Test
    public void notifyFullParkingWhenParkingIsFullUsingMockito () throws ParkingSpaceFullException, CarAlreadyParkedException, CarNotPresentException {
        ParkingLot parkingLot = new ParkingLot(1, parkingLotOwner);
        Car car = new Car("UP2561");
        parkingLot.park(car);
        verify(parkingLotOwner).notifyFullParking();
    }
}
