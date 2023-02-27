package com.example.crosstheroad;

import org.junit.Test;

public class MoveRightTest {
    @Test
    public void moveRightTest() {
        GameView.setCharX(500);
        GameView.setCharX(500 + Background.tileLength);
        assert GameView.getCharY() == 500 + Background.tileLength;
    }
}
