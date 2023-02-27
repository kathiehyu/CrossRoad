package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;

public class MoveRightTest {
    private Movement move;
    int tileLength;
    int screenWidth = 1080;
    int screenHeight = 1920;

    @Before
    public void setUp() {
        MainActivity.setScreenX(screenWidth);
        MainActivity.setScreenY(screenHeight);
        tileLength = screenWidth / Background.getWidthInTiles();
    }
    @Test
    public void moveRightTest() {
        move.setCharX(500);
        move.setCharX(500 + tileLength);
        assert move.getCharX() == 500 + tileLength;
    }
}
