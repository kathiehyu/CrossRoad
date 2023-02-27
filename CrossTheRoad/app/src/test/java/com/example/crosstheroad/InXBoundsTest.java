package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;

public class InXBoundsTest {

    private Movement move;
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
    public void testCharacterStaysInXBounds() {
        move.setCharX(100);
        assert move.getCharX() >= 0;
        System.out.println(move.getCharX());

        move.setCharX(2000);
        assert move.getCharX() < 1080;
    }
}
