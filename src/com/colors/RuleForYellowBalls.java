package com.colors;

import java.util.Set;

public class RuleForYellowBalls implements Rule {

    @Override
    public boolean isConditionsMet(Set<Ball> balls, Ball inputBall) {
        return numberOfBallsOfColor(Color.YELLOW, balls)+1 < balls.size()*0.4;
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
        return "Number of yellow balls cannot be more than 40% of total balls in bag";
    }

}
