package com.example.crosstheroad;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test to see if the IDs are the same then the they are the same
 */
public class DifferentIDsUnitTest {
    private GameScreen gameScreen;

    public void setUp() {
        gameScreen = new GameScreen();
    }
    @Test
    public void differentLives() {
        int id1 = 1;
        int id2 = 2;
        boolean result = gameScreen.checkDifferentLife(id1, id2);
        assertFalse(result);
    }
}