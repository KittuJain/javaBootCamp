package com.company;

public class Car {
    private String number;

    public Car(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return number.equals(car.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
