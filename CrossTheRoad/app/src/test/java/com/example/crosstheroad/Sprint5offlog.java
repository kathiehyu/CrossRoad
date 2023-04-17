package com.example.crosstheroad;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sprint5offlog {
    private GameActivity game;
    private Character player;

    /**
     * Test that the player loses a life if they step off a log into a river tile
     */
    @Test
    public void testPlayerLosesLifeWhenSteppingIntoRiver() {
        game = new GameActivity();
        player = new Character(game);

        // Set up a log at position (3, 1)
        boolean isLog = true;
        int speed = 2;
        int direction = 1; // left to right
        game.setTile(3, 1, isLog, speed, direction);

        // Move the player onto the log
        player.setPosition(3, 1);
        player.setMoving(true);
        player.setDirection(1); // left to right

        // Wait for 2 game ticks (enough for the log to move 2 spaces to the right)
        game.update();
        game.update();

        // Move the player off the log and into a river tile
        player.setMoving(false);
        player.setDirection(0); // up
        player.setPosition(3, 3);

        // The player should have lost a life and respawned at the starting position
        assertEquals(2, player.getLives());
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }
}
