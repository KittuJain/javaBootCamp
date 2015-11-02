package com.company;

public class Receipt {

    private final int number;

    public Receipt(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        return number == receipt.number;

    }

    @Override
    public int hashCode() {
        return number;
    }
}
