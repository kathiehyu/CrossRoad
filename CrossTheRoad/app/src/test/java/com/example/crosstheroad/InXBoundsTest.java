package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;

public class InXBoundsTest {

    private GameView gameView;
    private int screenWidth;
    private int screenHeight;

    @Before
    public void setUp() {
        screenWidth = 1080;
        screenHeight = 1920;
    }

    @Test
    public void testCharacterStaysInXBounds() {
        GameView.setCharX(-100);
        assert gameView.getCharX() >= 0;

        GameView.setCharX(2000);
        assert gameView.getCharX() < 1080;
    }
}
