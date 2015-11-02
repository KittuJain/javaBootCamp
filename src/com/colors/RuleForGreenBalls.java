package com.colors;

import java.util.Set;

public class RuleForGreenBalls implements Rule {

    @Override
    public boolean isConditionsMet(Set<Ball> balls, Ball inputBall) {
        return numberOfBallsOfColor(Color.GREEN, balls) < 3;
    }

    @Override
    public String sendError() {
        return "Number of green balls cannot be more than 3";
    }

    private int numberOfBallsOfColor(Color color, Set<Ball> balls) {
        int count = 0 ;
        for (Ball ball : balls){
            if(ball.isColor(color))
                count++;
        }
        return count;
    }
}
