package com.example.crosstheroad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class Sprint5TestGoalTile {
    /**
     * this test check if the character touch the water tile
     */
    @Test
    public void testWaterTileColliding(){
        int water = 0;
        int charY = 0;
        assertTrue(GameActivity.checkWaterTileColliding(water, charY));
    }
}
