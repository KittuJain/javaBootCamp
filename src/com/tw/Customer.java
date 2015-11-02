package com.tw;

public class Customer {

    private String name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        String result = "Rental Record for " + name + "\n";

        for (Rental rental: rentals) {
            result += rental.getRentedMovieStatement();
        }
        result += "Amount owed is " + calculateTotalRentedAmount() + "\n";
        result += "You earned " + calculateTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double calculateTotalRentedAmount() {
        double totalAmount = 0;
        for (Rental rental: rentals) {
            totalAmount += rental.getRentedAmount();
        }
        return totalAmount;
    }

    private int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental: rentals)
            frequentRenterPoints += rental.getFrequentRenterPoints();
        return frequentRenterPoints;
    }


}
