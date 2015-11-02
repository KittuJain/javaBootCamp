package com.colors;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BagTest {
    Map<Color, Rule> rules = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        rules.put(Color.GREEN, new RuleForGreenBalls());
        rules.put(Color.YELLOW, new RuleForYellowBalls());
        rules.put(Color.RED, new RuleForRedBalls());
        rules.put(Color.BLUE, new RuleForBlueBalls());
    }

    @Test
    public void addBallShouldAddGreenBallInTheBag() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        Map<Color, Integer> expectedBagSummary = new HashMap<>();

        expectedBagSummary.put(Color.GREEN, 1);
        expectedBagSummary.put(Color.YELLOW, 0);
        expectedBagSummary.put(Color.RED, 0);
        expectedBagSummary.put(Color.BLUE, 0);
        assertEquals(expectedBagSummary, bag.summary());
    }

    @Test
    public void addBallShouldAddBallsInTheBag() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.YELLOW));
        Map<Color, Integer> expectedBagSummary = new HashMap<>();

        expectedBagSummary.put(Color.GREEN, 2);
        expectedBagSummary.put(Color.YELLOW, 1);
        expectedBagSummary.put(Color.RED, 0);
        expectedBagSummary.put(Color.BLUE, 1);
        assertEquals(expectedBagSummary, bag.summary());
    }

    @Test
    public void addBallShouldAddBallOfEachColorInTheBag() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.YELLOW));
        Map<Color, Integer> expectedBagSummary = new HashMap<>();

        expectedBagSummary.put(Color.GREEN, 1);
        expectedBagSummary.put(Color.YELLOW, 1);
        expectedBagSummary.put(Color.RED, 1);
        expectedBagSummary.put(Color.BLUE, 1);
        assertEquals(expectedBagSummary, bag.summary());
    }

    @Test
    public void addBallShouldAllowToAdd3GreenBalls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
    }

    @Test(expected = RuleViolationException.class)
    public void addBallShouldThrowAnErrorOnAddingMoreThan3GreenBalls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
    }

    @Test
    public void addBallShouldAllowToAddRedBallsTwiceOfGreenBalls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
    }

    @Test(expected = RuleViolationException.class)
    public void addBallShouldThrowAnErrorOnAddingRedBallsMoreThanTwiceOfGreenBalls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
    }

    @Test
    public void addBallShouldAddYellowBalls40PercentOfTotalBalls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.YELLOW));
    }

    @Test(expected = RuleViolationException.class)
    public void addBallShouldThrowAnErrorOnAddingYellowBallsMoreThan40PercentOfTotalBalls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.YELLOW));
        bag.addBall(new Ball(Color.YELLOW));
        bag.addBall(new Ball(Color.YELLOW));
    }

    @Test
    public void addBallShouldNotHaveAnyLimitationsOnAddingBlueBalls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        Map<Color, Integer> expectedBagSummary = new HashMap<>();

        expectedBagSummary.put(Color.GREEN, 0);
        expectedBagSummary.put(Color.YELLOW, 0);
        expectedBagSummary.put(Color.RED, 0);
        expectedBagSummary.put(Color.BLUE, 8);
        assertEquals(expectedBagSummary, bag.summary());
    }

    @Test(expected = RuleViolationException.class)
    public void addBallShouldNotAllowToAddRedBallsMoreThanGreenOnes() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
    }

    @Test(expected = BagFullException.class)
    public void addBallShouldNotAllowToAddMoreThan12Balls() throws RuleViolationException, BagFullException {
        Bag bag = new Bag(rules);
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.GREEN));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.RED));
        bag.addBall(new Ball(Color.YELLOW));
        bag.addBall(new Ball(Color.YELLOW));
        bag.addBall(new Ball(Color.YELLOW));
    }
}
