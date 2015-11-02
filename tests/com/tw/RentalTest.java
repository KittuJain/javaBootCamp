package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

public class RentalTest {

    @Test
    public void getRentedAmountGetsTheAmountForNewRelease() throws Exception {
        Rental rental = new Rental(new NewReleaseMovie("The Martians"), 4);
        assertEquals(12.0, rental.getRentedAmount(), 0.1);
    }

    @Test
    public void getRentedAmountGetsTheAmountForChildren() throws Exception {
        Rental rental = new Rental(new ChildrensMovie("Tom and Jerry", 1.5, 1.5, 3), 4);
        assertEquals(3.0, rental.getRentedAmount(), 0.1);
    }

    @Test
    public void getRentedAmountGetsTheAmountForRegular() throws Exception {
        Rental rental = new Rental(new RegularMovie("PK"), 4);
        assertEquals(5.0, rental.getRentedAmount(), 0.1);
    }

    @Test
    public void getFrequentRenterPointsShouldGetFrequentRenterPointsForNewReleaseMovie() throws Exception {
        Rental rental = new Rental(new NewReleaseMovie("The Martians"), 4);
        assertEquals(2, rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsShouldGetFrequentRenterPointsForChildrenMovie() throws Exception {
        Rental rental = new Rental(new ChildrensMovie("Tom and Jerry", 1.5, 1.5, 3), 4);
        assertEquals(1, rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsShouldGetFrequentRenterPointsForRegularMovie() throws Exception {
        Rental rental = new Rental(new RegularMovie("PK"), 4);
        assertEquals(1, rental.getFrequentRenterPoints());
    }

}