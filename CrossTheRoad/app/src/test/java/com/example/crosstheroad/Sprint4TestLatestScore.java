package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sprint4TestLatestScore {

    /**
     * Test if the game can keep track of the latest score
     */
    @Test
    public void testLatestScore() {
        int currentScore = 100;
        int newScore = 200;
        GameActivity.setScore(currentScore);
        GameActivity.setScore(newScore);
        assertEquals(newScore, GameActivity.getLatestScore());
    }
}
