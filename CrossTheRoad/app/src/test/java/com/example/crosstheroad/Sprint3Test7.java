package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sprint3Test7 {
    /***
     * Test if the updated score equals the actual score at beginning of game
     */
    @Test
    public void testUpdateScore() {
        GameActivity.setCurrentRow(8);
        int expectedScore = 0;
        int actualScore = GameActivity.updateScore();
        assertEquals(expectedScore, actualScore);
    }
}
