package com.example.crosstheroad;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.example.crosstheroad.GameActivity;
/***
 * checks that when a player in the GameActivity moves down from row 13 to row 12, their score increases by 1.
 */
public class Sprint3Test5 {
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
        assertEquals(7, GameActivity.getScore());
    }
}