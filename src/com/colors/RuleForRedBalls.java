package com.colors;

import java.util.Set;

public class RuleForRedBalls implements Rule {

    @Override
    public boolean isConditionsMet(Set<Ball> balls, Ball inputBall) {
        return numberOfBallsOfColor(Color.RED, balls) < 2*(numberOfBallsOfColor(Color.GREEN, balls));
    }

    private int numberOfBallsOfColor(Color color, Set<Ball> balls) {
        int count = 0 ;
        for (Ball ball : balls){
            if(ball.isColor(color))
                count++;
        }
        return count;
    }

    @Override
    public String sendError() {
        return "Number of red balls cannot be more than double the green balls";
    }
}
