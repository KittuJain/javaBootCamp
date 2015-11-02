package com.colors;

import java.util.*;

public class Bag {

    Set<Ball> balls = new HashSet<>();
    Map<Color, Rule> rules;

    public Bag(Map<Color, Rule> rules) {
        this.rules = rules;
    }

    public void addBall(Ball ball) throws RuleViolationException, BagFullException {
        if(isFull())
            throw new BagFullException("Bag is full");
        else {
            Rule rule = rules.get(findColor(ball));
            if(!rule.isConditionsMet(balls, ball))
                throw new RuleViolationException(rule.sendError());
            balls.add(ball);
        }
    }

    private Color findColor(Ball ball) {
        Color ballColor = null;
        for (Color color : rules.keySet()){
            if(ball.isColor(color))
                ballColor =  color;
        }
        return ballColor;
    }

    public boolean isFull() {
        return balls.size() >= 12;
    }

    private int getCountOf(Color color) {
        int count = 0 ;
        for (Ball ball : balls){
            if(ball.isColor(color)) count++;
        }
        return count;
    }

    public Map<Color, Integer> summary() {
        Map<Color, Integer> bagSummary = new HashMap<>();
        bagSummary.put(Color.BLUE, getCountOf(Color.BLUE));
        bagSummary.put(Color.GREEN, getCountOf(Color.GREEN));
        bagSummary.put(Color.YELLOW, getCountOf(Color.YELLOW));
        bagSummary.put(Color.RED, getCountOf(Color.RED));
        return bagSummary;
    }
}