package com.colors;

public class Ball {
    private final Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public boolean isColor(Color color) {
        return this.color == color;
    }

}
