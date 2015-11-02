package com.tw;

public class NewReleaseMovie extends Movie {
    private double upFrontCost;
    private double perDayCost;
    private int upFrontValidity;

    public NewReleaseMovie(String title) {
        super(title);
        upFrontCost = 0;
        perDayCost = 3;
        upFrontValidity = 0;
    }

    @Override
    public double getCostFor(int daysRented) {
        return daysRented * perDayCost;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
