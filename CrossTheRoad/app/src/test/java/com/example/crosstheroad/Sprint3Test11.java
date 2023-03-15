package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import android.widget.RadioButton;

import org.junit.Test;

public class Sprint3Test11 {
    /***
     * tests that the characterChoice method returns false when passed a null argument
     */

    @Test
    public void testCharacterChoice() {
        assertFalse(Configuration.characterChoice(null));
    }
}