package com.shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void getAreaGetsAreaOfRectangle () throws InvalidDimensionException {
        Rectangle rectangle = Rectangle.createRectangle(3, 3);
        double area = rectangle.getArea();
        assertEquals(9, area, 0.0);
    }

    @Test
    public void getAreaGetsAreaOfRectangleForDecimalPointNumbers () throws InvalidDimensionException {
        Rectangle rectangle = Rectangle.createRectangle(3.2, 5.6);
        double area = rectangle.getArea();
        assertEquals(17.92, area, 0.1);
    }

    @Test
    public void getPerimeterGetsPerimeterOfRectangle () throws InvalidDimensionException {
        Rectangle rectangle = Rectangle.createRectangle(3, 3);
        double perimeter = rectangle.getPerimeter();
        assertEquals(12, perimeter, 0.0);
    }

    @Test
    public void getPerimeterGetsPerimeterOfRectangleForDecimalPointNumbers () throws InvalidDimensionException {
        Rectangle rectangle = Rectangle.createRectangle(3.2, 5.6);
        double perimeter = rectangle.getPerimeter();
        assertEquals(17.6, perimeter, 0.1);
    }

    @Test(expected = InvalidDimensionException.class)
    public void createRectangleShouldThrowExceptionWhenItsBreadthIs0 () throws InvalidDimensionException {
        Rectangle.createRectangle(5, 0);
    }

    @Test(expected = InvalidDimensionException.class)
    public void createRectangleShouldThrowExceptionWhenDimensionsAreNegative () throws InvalidDimensionException {
        Rectangle.createRectangle(-3, 2);
    }
}
