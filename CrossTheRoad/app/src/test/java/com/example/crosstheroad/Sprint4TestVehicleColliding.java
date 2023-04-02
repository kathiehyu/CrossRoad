package com.example.crosstheroad;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.widget.RadioButton;

import org.junit.Test;
public class Sprint4TestVehicleColliding {
    private GameActivity live;
    private Movement move;

    /**
     * Colliding with any vehicle decrease the remaining lives by one
     */
    @Test
    public void testVehicleColliding(){
        int liveBefore = 3;
        int liveAfter = 2;
        assertTrue(GameActivity.checkVehicleCollision(liveBefore - 1, liveAfter));
    }
}
