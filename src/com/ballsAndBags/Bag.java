package com.ballsAndBags;

import com.colors.Ball;
import com.colors.BagFullException;
import com.colors.Color;
import com.colors.RuleViolationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bag {

    List<Ball> balls = new ArrayList<>();
    int redBalls = 0;
    int yellowBalls = 0;
    int blueBalls = 0;
    int greenBalls = 0;

    public void addBall(Ball ball) throws RuleViolationException, BagFullException {
        if(isFull())
            throw new BagFullException("Bag is full");
        else {
            if (ball.isColor(Color.RED)) addRedBall(ball);
            if (ball.isColor(Color.YELLOW)) addYellowBall(ball);
            if (ball.isColor(Color.GREEN)) addGreenBall(ball);
            if (ball.isColor(Color.BLUE)) addBlueBall(ball);
        }
    }

    private void addRedBall(Ball ball) throws RuleViolationException, BagFullException {
        if(redBalls < 2*greenBalls) {
            redBalls++;
            balls.add(ball);
        }
        else throw new RuleViolationException("Number of red balls cannot be more than double the green balls");
    }

    private void addBlueBall(Ball ball) {
        blueBalls++;
        balls.add(ball);
    }

    private void addYellowBall(Ball ball) throws RuleViolationException {
        if(yellowBalls+1 <= balls.size()*0.4) {
            yellowBalls++;
            balls.add(ball);
        }
        else throw new RuleViolationException("Number of yellow balls cannot be more than 40% of total balls in bag");
    }

    private void addGreenBall(Ball ball) throws RuleViolationException {
        if(greenBalls < 3) {
            greenBalls++;
            balls.add(ball);
        }
        else throw new RuleViolationException("Number of green balls cannot be more than 3");
    }

    public Map<Color, Integer> summary() {
        Map<Color, Integer> bagSummary = new HashMap<>();
        bagSummary.put(Color.BLUE, blueBalls);
        bagSummary.put(Color.GREEN, greenBalls);
        bagSummary.put(Color.YELLOW, yellowBalls);
        bagSummary.put(Color.RED, redBalls);
        return bagSummary;
    }

    public boolean isFull() {
        return balls.size() >= 12;
    }
}
