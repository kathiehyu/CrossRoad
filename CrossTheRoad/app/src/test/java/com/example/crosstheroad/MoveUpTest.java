package com.example.crosstheroad;

import org.junit.Test;

public class MoveUpTest {
    @Test
    public void moveUpTest() {
        GameView.setCharY(500);
        GameView.setCharY(500 - Background.tileLength);
        assert GameView.getCharY() == 500 - Background.tileLength;
    }
}
