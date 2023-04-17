package com.example.crosstheroad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class Sprint5TestDifferentLogs {
    /**
     * this test check if the character collide with the first obstacle
     */
    @Test
    public void testFirstObstacleColliding(){
        int charX = 2;
        int obstacleX = 2;
        assertTrue(GameActivity.checkObstacleColliding(charX, obstacleX));
    }

}
