package com.example.crosstheroad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Sprint5TestJumpingOnLogs {
    //jumping on logs does not lose life

    private GameActivity game;

    @Before
    public void setUp() {
        game = new GameActivity();
    }

    @Test
    public void testJumpingOnLogsDoesNotLoseLife() {
        // Set up the game with the player on a log
        game.setMovement(new Movement());
        game.getMovement().setRow(2); // Set the player's row to the row of logs
        game.getMovement().setCharX(50); // Set the player's x-coordinate to be on a log

        // Check that the player has not lost a life yet
        int initialLives = game.getLives();
        assertFalse(game.checkCollisions());

        // Move the player off the log and check that they still haven't lost a life
        game.getMovement().setCharX(100);
        assertFalse(game.checkCollisions());

        // Move the player back onto the log and check that they still haven't lost a life
        game.getMovement().setCharX(50);
        assertFalse(game.checkCollisions());

        // Move the player off the log again and check that they still haven't lost a life
        game.getMovement().setCharX(100);
        assertFalse(game.checkCollisions());

        // Check that the player's lives have not decreased
        assertEquals(initialLives, game.getLives());
    }
}
