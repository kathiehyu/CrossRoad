package com.example.crosstheroad;

import static org.junit.Assert.assertFalse;

import android.widget.RadioButton;

import org.junit.Test;

public class Sprint3Test12 {
    /***
     * check that the difficultylevel method returns false when null is passed in as an argument
     */

    @Test
    public void testDifficultyLevel() {
        RadioButton radioButton = new RadioButton(null);
        assertFalse(Configuration.difficultyLevel(null));
    }
}