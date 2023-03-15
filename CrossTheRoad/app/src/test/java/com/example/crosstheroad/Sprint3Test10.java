package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.graphics.Canvas;

import org.junit.Test;


public class Sprint3Test10 {
    /***
     * current row 8 and highest row 15 so char on safe tile, checks if expected score equals the actual score
     */

    @Test
    public void testUpdateScore() {
        GameActivity.currentRow = 8;
        GameActivity.highestRow = 15;
        int expectedScore = 0;

        int actualScore = GameActivity.updateScore();

        assertEquals(expectedScore, actualScore);
    }
}