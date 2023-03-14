package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;

public class Sprint3Test4 {
    @Before
    public void setRow13() {
        GameActivity.setCurrentRow(14);
        GameActivity.updateScore();
        GameActivity.setCurrentRow(13);
        GameActivity.updateScore();
    }
    @Test
    public void moveDownFromRow13to12() {
        GameActivity.setCurrentRow(12);
        assert GameActivity.getScore() == 7;
    }
}
