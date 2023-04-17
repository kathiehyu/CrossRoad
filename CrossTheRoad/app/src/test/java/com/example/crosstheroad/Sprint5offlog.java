package com.example.crosstheroad;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mock;

public class Sprint5offlog {
    @Mock
    private GameActivity game = mock(GameActivity.class);

    /**
     * Test that jumping on logs does not cause the player toreturn to the beginning
     */
    @Test
    public void testJumpOnLog() {
        // Set up player position and log position
        int playerX = 0;
        int playerY = 0;

        // Check that the player did not respawn
        assertTrue(game.checkRespawned(playerX, playerY));
    }
}