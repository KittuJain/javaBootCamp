package com.colors;

import java.util.Set;

public class RuleForBlueBalls implements Rule {

    @Override
    public boolean isConditionsMet(Set<Ball> ballsInBag, Ball inputBall) {
        return ballsInBag.size() < 12;
    }

    @Override
    public String sendError() {
        return "Number of blue balls cannot be more than 12";
    }

}
