package com.example.crosstheroad;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Sprint5WinScreen {
    @Test
    public void testWinScreenCongratulatesPlayer() {
        int score = 200; // Set a score that's high enough to win the game
        String winMessage = GameActivity.getWinMessage(score);
        String expectedMessage = "Congratulations, you won! Final Score: " + score;

        assertEquals(expectedMessage, winMessage);
    }
}
