package com.tw;

enum PriceCode {
    CHILDRENS(1.5, 1.5, 3),
    NEW_RELEASE(0, 3, 0),
    REGULAR(2, 1.5, 2);

    private double upFrontCost;
    private double perDayCost;
    private int upFrontValidity;

    PriceCode(double upFrontCost, double perDayCost, int upFrontValidity) {

        this.upFrontCost = upFrontCost;
        this.perDayCost = perDayCost;
        this.upFrontValidity = upFrontValidity;
    }

    public double getCostFor(int daysRented) {
        double rentalAmount = upFrontCost;
        if (daysRented > upFrontValidity)
            rentalAmount += (daysRented - upFrontValidity) * perDayCost;
        return rentalAmount;
    }
}
