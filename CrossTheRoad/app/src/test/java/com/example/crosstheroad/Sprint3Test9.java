package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sprint3Test9 {
    /***
     * Test whether the score variable is updated correctly or not
     */
    @Test
    public void testUpdateScore() {
        GameActivity.currentRow = 9;
        GameActivity.highestRow = 10;
        int initialScore = GameActivity.getScore();

        GameActivity.updateScore();

        assertEquals(initialScore + GameActivity.safeScore, GameActivity.getScore());
    }
}