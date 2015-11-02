package com.shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {
    @Test
    public void getAreaGetsAreaOfSquare () throws InvalidDimensionException {
        Rectangle square = Rectangle.createSquare(3);
        double area = square.getArea();
        assertEquals(9, area, 0.0);
    }

    @Test
    public void getAreaGetsAreaOfSquareForDecimalPointNumbers () throws InvalidDimensionException {
        Rectangle square = Rectangle.createSquare(3.2);
        double area = square.getArea();
        assertEquals(10.24, area, 0.1);
    }

    @Test
    public void getPerimeterGetsPerimeterOfSquare () throws InvalidDimensionException {
        Rectangle square = Rectangle.createSquare(3);
        double area = square.getPerimeter();
        assertEquals(12, area, 0.0);
    }

    @Test
    public void getPerimeterGetsPerimeterOfSquareForDecimalPointNumbers () throws InvalidDimensionException {
        Rectangle square = Rectangle.createSquare(3.2);
        double area = square.getPerimeter();
        assertEquals(12.8, area, 0.1);
    }

    @Test(expected = InvalidDimensionException.class)
    public void createSquareShouldThrowExceptionWhenDimensionsIs0 () throws InvalidDimensionException {
        Rectangle.createSquare(0);
    }

    @Test(expected = InvalidDimensionException.class)
    public void createSquareShouldThrowExceptionWhenDimensionsAreNegative () throws InvalidDimensionException {
        Rectangle.createSquare(-3);
    }
}
