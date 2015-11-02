package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void getCostForGetsCostForNewReleaseFor4DaysRented() throws Exception {
        Movie movie = new Movie("The Martians", PriceCode.NEW_RELEASE);
        assertEquals(12.0, movie.getCostFor(4), 0.1);
    }

    @Test
    public void getCostForGetsCostForRegularFor4DaysRented() throws Exception {
        Movie movie = new Movie("PK", PriceCode.REGULAR);
        assertEquals(5.0, movie.getCostFor(4), 0.1);
    }

    @Test
    public void getCostForGetsCostForChildrenFor4DaysRented() throws Exception {
        Movie movie = new Movie("Tom and Jerry", PriceCode.CHILDRENS);
        assertEquals(3.0, movie.getCostFor(4), 0.1);
    }
}