package com.tw;

public class ChildrensMovie extends Movie {
    private double upFrontCost;
    private double perDayCost;
    private int upFrontValidity;

    public ChildrensMovie(String title, double upFrontCost, double perDayCost, int upFrontValidity) {
        super(title);
        this.upFrontCost = upFrontCost;
        this.perDayCost = perDayCost;
        this.upFrontValidity = upFrontValidity;
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
