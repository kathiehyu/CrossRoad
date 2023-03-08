package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;

public class MoveDownTest {
    private Movement move;
    int tileLength;
    @Before
    public void setUp() {
        int screenWidth = 1080;
        int screenHeight = 1920;
        MainActivity.setScreenX(screenWidth);
        MainActivity.setScreenY(screenHeight);
        tileLength = screenWidth / Background.getWidthInTiles();
    }
    @Test
    public void moveDownTest() {
        move.setCharY(500);
        move.setCharY(500 + tileLength);
        assert move.getCharY() == 500 + tileLength;
    }
}
