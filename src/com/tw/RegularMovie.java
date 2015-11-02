package com.tw;

public class RegularMovie extends Movie {
    private double upFrontCost;
    private double perDayCost;
    private int upFrontValidity;

    public RegularMovie(String title) {
        super(title);
        upFrontCost = 2;
        perDayCost = 1.5;
        upFrontValidity = 2;
    }

    @Override
    public double getCostFor(int daysRented) {
        double rentalAmount = upFrontCost;
        if (daysRented > upFrontValidity)
            rentalAmount += (daysRented - upFrontValidity) * perDayCost;
        return rentalAmount;
    }
    
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
