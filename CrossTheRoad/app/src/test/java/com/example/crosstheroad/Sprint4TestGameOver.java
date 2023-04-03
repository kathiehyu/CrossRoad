package com.example.crosstheroad;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * If life = 0, the GameOverScreen will get started
 */
public class Sprint4TestGameOver {
    @Mock
    private GameActivity game = mock(GameActivity.class);
    @Test
    public void TestGameOverScreen() {
        // Set up the mock object
        Mockito.when(game.getLives()).thenReturn(0);

        // Call the method under test
        boolean isGameOver = game.GameOver();

        // Verify the result
        assertTrue(isGameOver);
    }
}
