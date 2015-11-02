package com.tw;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getRentedAmount() {
        return movie.getCostFor(daysRented);
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        if ((movie.getPriceCode() == PriceCode.NEW_RELEASE) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public String getRentedMovieStatement() {
        return "\t" + movie.getTitle() + "\t" + getRentedAmount() + "\n";
    }
}
