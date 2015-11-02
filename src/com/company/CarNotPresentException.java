package com.company;

public class CarNotPresentException extends Exception{
    public CarNotPresentException(String message) {
        super(message);
    }
}
