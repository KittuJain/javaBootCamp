package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

public class RentalTest {

    @Test
    public void getRentedAmountGetsTheAmountForNewRelease() throws Exception {
        Rental rental = new Rental(new Movie("The Martians", PriceCode.NEW_RELEASE), 4);
        assertEquals(12.0, rental.getRentedAmount(), 0.1);
    }

    @Test
    public void getRentedAmountGetsTheAmountForChildren() throws Exception {
        Rental rental = new Rental(new Movie("Tom and Jerry", PriceCode.CHILDRENS), 4);
        assertEquals(3.0, rental.getRentedAmount(), 0.1);
    }

    @Test
    public void getRentedAmountGetsTheAmountForRegular() throws Exception {
        Rental rental = new Rental(new Movie("PK", PriceCode.REGULAR), 4);
        assertEquals(5.0, rental.getRentedAmount(), 0.1);
    }

    @Test
    public void getFrequentRenterPointsShouldGetFrequentRenterPointsForNewReleaseMovie() throws Exception {
        Rental rental = new Rental(new Movie("The Martians", PriceCode.NEW_RELEASE), 4);
        assertEquals(2, rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsShouldGetFrequentRenterPointsForChildrenMovie() throws Exception {
        Rental rental = new Rental(new Movie("Tom and Jerry", PriceCode.CHILDRENS), 4);
        assertEquals(1, rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsShouldGetFrequentRenterPointsForRegularMovie() throws Exception {
        Rental rental = new Rental(new Movie("PK", PriceCode.REGULAR), 4);
        assertEquals(1, rental.getFrequentRenterPoints());
    }

}