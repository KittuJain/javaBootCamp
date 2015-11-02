package com.tw;

public class Rental {

    Movie movie;
    protected int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getRentedAmount() {
        return movie.getCostFor(daysRented);
    }

    public String getRentedMovieStatement() {
        return "\t" + movie.getTitle() + "\t" + getRentedAmount() + "\n";
    }

    public int getFrequentRenterPoints(){
        return movie.getFrequentRenterPoints(daysRented);
    }
}
