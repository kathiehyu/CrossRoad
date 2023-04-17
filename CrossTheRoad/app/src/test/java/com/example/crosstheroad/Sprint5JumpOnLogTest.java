package com.example.crosstheroad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Sprint5JumpOnLogTest {
    private GameActivity game;
    private Movement movement;

    @Before
    public void setUp() {
        game = new GameActivity();
    }

    /**
     * Test that jumping on logs does not cause the player toreturn to the beginning
     */
    @Test
    public void testJumpOnLog() {
        // Set up player position and log position
        int playerX = 100;
        int playerY = 200;
        int logX = 150;
        int logY = 200;

        // Check that the player did not respawn
        assertFalse(game.checkRespawned(playerX, playerY));
    }
}
