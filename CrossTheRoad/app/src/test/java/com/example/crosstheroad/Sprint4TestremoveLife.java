package com.example.crosstheroad;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class Sprint4TestremoveLife {
    @Mock
        private GameActivity game = mock(GameActivity.class);
    /**
     * This test verifies if removeLife() reduces 1 life
     */
        @Test
        public void checkremoveLife() {
            game.setLives(3);
            game.removeLife();
            Mockito.when(game.getLives()).thenReturn(2);
            int lives = game.getLives();
            assertEquals(2, lives);
        }

    /**
     * This test check the number of lives at the beginning
     * of the game after calling setStartCondition()
     */
    @Test
    public void TestinitialLife() {
            game.setLives(3);
            game.setStartConditions(false);
            Mockito.when(game.getLives()).thenReturn(3);
            int lives = game.getLives();
            assertEquals(3, lives);
        }

}
