package com.example.crosstheroad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class Sprint4TestFourthMoveableColliding {
    /**
     * this test check if the character collide with the first obstacle
     */
    @Test
    public void testFirstObstacleColliding(){
        int charX = 3;
        int obstacleX = 3;
        assertTrue(GameActivity.checkObstacleColliding(charX, obstacleX));
    }

}
