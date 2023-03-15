package com.example.crosstheroad;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.crosstheroad.GameActivity;

public class Sprint3Test6{
    /***
     * Test the initial score
     */
    @Test
    public void testUpdateScore() {
        // Test the initial score
        int initialScore = GameActivity.updateScore();
        assertEquals(0, initialScore);
    }
}