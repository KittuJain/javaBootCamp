package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void getCostForGetsCostForNewReleaseFor4DaysRented() throws Exception {
        Movie movie = new NewReleaseMovie("The Martians");
        assertEquals(12.0, movie.getCostFor(4), 0.1);
    }

    @Test
    public void getCostForGetsCostForRegularFor4DaysRented() throws Exception {
        Movie movie = new RegularMovie("PK");
        assertEquals(5.0, movie.getCostFor(4), 0.1);
    }

    @Test
    public void getCostForGetsCostForChildrenFor4DaysRented() throws Exception {
        Movie movie = new ChildrensMovie("Tom and Jerry", 1.5, 1.5, 3);
        assertEquals(3.0, movie.getCostFor(4), 0.1);
    }
}