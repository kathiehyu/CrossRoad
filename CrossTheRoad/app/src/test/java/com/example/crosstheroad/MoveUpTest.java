package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;

public class MoveUpTest {
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
    public void moveUpTest() {
        move.setCharY(500);
        move.setCharY(500 - tileLength);
        assert move.getCharY() == 500 - tileLength;
    }
}
