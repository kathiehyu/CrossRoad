package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;

public class InYBoundsTest {

    private GameView gameView;
    private int screenWidth;
    private int screenHeight;

    @Before
    public void setUp() {
        screenWidth = 1080;
        screenHeight = 1920;
    }

    @Test
    public void testCharacterStaysInYBounds() {
        GameView.setCharY(-100);
        assert gameView.getCharY() >= 0;

        GameView.setCharY(2000);
        assert gameView.getCharY() < 1920;
    }
}
