package com.shape;

public class Rectangle {

    private double length;
    private double breadth;

    private Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public static Rectangle createRectangle(double length, double breadth) throws InvalidDimensionException {
        if(length <= 0 || breadth <= 0)
            throw new InvalidDimensionException("Dimensions of Rectangle cannot be negative");
        return new Rectangle(length, breadth);
    }

    public static Rectangle createSquare(double size) throws InvalidDimensionException {
        if(size <= 0)
            throw new InvalidDimensionException("Dimensions of Square cannot be negative");
        return new Rectangle(size, size);
    }

    public double getArea() {
        return length * breadth;
    }

    public double getPerimeter() {
        return 2* (length + breadth);
    }
}
