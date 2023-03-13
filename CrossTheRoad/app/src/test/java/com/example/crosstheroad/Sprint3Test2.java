package com.example.crosstheroad;

import org.junit.Test;

public class Sprint3Test2 {
    /**
     * From origin, if moving up 1 row, score + 4
     */
    @Test
    public void moveUpFromOrigin() {
        GameActivity.setCurrentRow(14);
        GameActivity.updateScore();
        assert GameActivity.getScore() == 4;
    }
}
