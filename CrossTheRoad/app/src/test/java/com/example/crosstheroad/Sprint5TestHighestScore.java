package com.example.crosstheroad;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.widget.RadioButton;

import org.junit.Test;
public class Sprint5TestHighestScore {

    /**
     * Test if the game can keep track maximum score
     */
    @Test
    public void testKeepMaxScore (){
        int score = 0;
        assertTrue(GameActivity.checkKeepMaxScore(score));
    }
}
