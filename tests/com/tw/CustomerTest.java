package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void statementShouldGetStatementForRentingNewReleaseMovie() throws Exception {
        Customer customer = new Customer("Ram");
        Rental rental = new Rental(new Movie("The Martians", PriceCode.NEW_RELEASE), 4);
        customer.addRental(rental);
        String statement = customer.statement();
        String expectedStatement = "Rental Record for Ram\n" +
                "\tThe Martians\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expectedStatement, statement);

    }

    @Test
    public void statementShouldGetStatementForRentingChildrenMovie() throws Exception {
        Customer customer = new Customer("Ram");
        Rental rental = new Rental(new Movie("Tom and Jerry", PriceCode.CHILDRENS), 4);
        customer.addRental(rental);
        String statement = customer.statement();
        String expectedStatement = "Rental Record for Ram\n" +
                "\tTom and Jerry\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, statement);

    }

    @Test
    public void statementShouldGetStatementForRentingRegularMovie() throws Exception {
        Customer customer = new Customer("Ram");
        Rental rental = new Rental(new Movie("PK", PriceCode.REGULAR), 4);
        customer.addRental(rental);
        String statement = customer.statement();
        String expectedStatement = "Rental Record for Ram\n" +
                "\tPK\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, statement);

    }
}