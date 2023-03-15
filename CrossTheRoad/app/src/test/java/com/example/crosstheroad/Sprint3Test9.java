package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sprint3Test9 {
    /***
     * Test if the updated score equals the actual score
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