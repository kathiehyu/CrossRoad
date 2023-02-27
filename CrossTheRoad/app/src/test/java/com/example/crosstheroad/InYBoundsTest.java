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
        MainActivity.setScreenX(screenWidth);
        MainActivity.setScreenY(screenHeight);
    }

    @Test
    public void testCharacterStaysInYBounds() {
        Movement.setCharY(-100);
        assert gameView.getCharY() >= 0;

        Movement.setCharY(2000);
        assert gameView.getCharY() < 1920;
    }
}
