package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;

import com.example.crosstheroad.GameActivity;
import com.example.crosstheroad.GameWinScreen;

import org.junit.Test;

public class Sprint5WinScreenScore {
    @Test
    public void testWinScreenScore() {
        int winScore = GameActivity.getGameScore();
        assertEquals(200, winScore);
    }
}