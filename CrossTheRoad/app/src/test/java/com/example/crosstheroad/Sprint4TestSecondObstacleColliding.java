package com.example.crosstheroad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.widget.RadioButton;
import org.junit.Test;
public class Sprint4TestSecondObstacleColliding {
    /**
     * this test check if the character collide with the first obstacle
     */
    @Test
    public void testSecondObstacleColliding(){
        int charX = 1;
        int obstacleX = 1;
        assertTrue(GameActivity.checkObstacleColliding(charX, obstacleX));
    }

}
