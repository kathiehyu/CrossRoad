package com.example.crosstheroad;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.widget.RadioButton;

import org.junit.Test;
public class Sprint4TestWaterTile {
    private GameActivity live;
    private Movement move;
    /**
     * Touching water tile decrease the remaining lives by one
     */
    @Test
    public void testWaterTile(){
        int liveBefore = 3;
        int liveAfter = 2;
        assertTrue(GameActivity.checkWaterTile(liveBefore - 1, liveAfter));
    }
}
