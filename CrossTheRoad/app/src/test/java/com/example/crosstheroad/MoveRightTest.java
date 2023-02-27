package com.example.crosstheroad;

import org.junit.Test;

public class MoveRightTest {
    @Test
    public void moveRightTest() {
        int init = 500;
        int tileLength = 154;
        GameActivity.moveRight();
        assert GameView.getCharX() == 500 + 154;
    }
}
