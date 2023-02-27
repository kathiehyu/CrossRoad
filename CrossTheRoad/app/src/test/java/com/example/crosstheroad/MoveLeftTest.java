package com.example.crosstheroad;

import org.junit.Test;

public class MoveLeftTest {
    @Test
    public void moveLeftTest() {
        GameView.setCharX(500);
        GameView.setCharX(500 - Background.tileLength);
        assert GameView.getCharY() == 500 - Background.tileLength;
    }
}
