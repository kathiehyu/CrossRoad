package com.example.crosstheroad;

import org.junit.Test;

public class MoveDownTest {
    @Test
    public void moveDownTest() {
        GameView.setCharY(500);
        GameView.setCharY(500 + Background.tileLength);
        assert GameView.getCharY() == 500 + Background.tileLength;
    }
}
