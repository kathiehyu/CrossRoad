package com.example.crosstheroad;

import org.junit.Test;

public class MoveUpTest {
    @Test
    public void moveUpTest() {
        int init = 500;
        int tileLength = 154;
        GameActivity.moveUp();
        assert GameView.getCharY() == 500 - 154;
    }
}
