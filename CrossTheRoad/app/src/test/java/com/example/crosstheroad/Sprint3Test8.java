package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sprint3Test8 {
    /***
     * Test if the updated score equals the actual score
     */
    @Test
    public void testUpdateScore() {
        GameActivity.currentRow = 8;
        int expectedScore = 0;
        int actualScore = GameActivity.updateScore();
        assertEquals(expectedScore, actualScore);
    }
}