package com.example.crosstheroad;

import org.junit.Test;

public class MoveDownTest {
    @Test
    public void moveDownTest() {
        int init = 100;
        GameView.setCharY(100);
        System.out.println(GameView.getCharY());
        GameActivity.moveDown();
        System.out.println(GameView.getCharY());
        assert GameView.getCharY() == 100 + Background.tileLength;
    }
}
