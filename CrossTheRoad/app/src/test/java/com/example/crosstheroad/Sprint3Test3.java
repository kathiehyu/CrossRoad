package com.example.crosstheroad;

import org.junit.Test;

public class Sprint3Test3 {
    @Test
    public void moveUpTwiceFromOrigin() {
        GameActivity.setCurrentRow(14);
        GameActivity.updateScore();
        GameActivity.setCurrentRow(13);
        GameActivity.updateScore();
        assert GameActivity.getScore() == 7;
    }
}
