package com.colors;

import java.util.Set;

interface Rule {
    boolean isConditionsMet(Set<Ball> ballsInBag, Ball inputBall);

    String sendError();

}
