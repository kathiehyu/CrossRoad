package com.example.crosstheroad;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.RadioButton;

/**
 * Class checks when a non-null button is clicked for choosing a difficulty
 */
public class NonNullDifficultyTest {
    RadioButton rb1 = new RadioButton(Configuration.getContext());
    @Test
    public void nonNullButton() {
        rb1.setChecked(true);
        assertTrue(Configuration.difficultyLevel(rb1));
    }
}