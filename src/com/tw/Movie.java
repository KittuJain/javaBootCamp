package com.tw;

public class Movie {

    private String _title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        _title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }


    public double getCostFor(int daysRented) {
        return priceCode.getCostFor(daysRented);
    }
}
