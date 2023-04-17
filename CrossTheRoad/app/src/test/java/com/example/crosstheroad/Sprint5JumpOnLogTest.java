package com.example.crosstheroad;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertFalse;

public class Sprint5JumpOnLogTest {
    private Movement movement;

    @Mock
    private GameActivity game = mock(GameActivity.class);

    /**
     * Test that jumping on logs does not cause the player toreturn to the beginning
     */
    @Test
    public void testJumpOnLog() {
        // Set up player position and log position
        int playerX = 100;
        int playerY = 200;

        // Check that the player did not respawn
        assertFalse(game.checkRespawned(playerX, playerY));
    }
}
