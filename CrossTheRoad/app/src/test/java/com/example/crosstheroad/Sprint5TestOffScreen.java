package com.example.crosstheroad;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.widget.RadioButton;

import org.junit.Test;
public class Sprint5TestOffScreen {
    private GameActivity live;
    private Movement move;

    /**
     * The player should be respawned at the initial starting point
     */
    @Test
    public void testRespawned(){
        int x = 0;
        int y = 0;
        assertTrue(GameActivity.checkRespawned(x, y));

    }
}

