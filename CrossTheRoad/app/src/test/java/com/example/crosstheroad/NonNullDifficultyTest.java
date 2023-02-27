package com.example.crosstheroad;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.RadioButton;

/**
 * Class checks when a non-null button is clicked for choosing a difficulty
 */
public class NonNullDifficultyTest {
    private Configuration configurationActivity;
    @Test
    public void nonNullButton() {
        RadioButton button = new RadioButton(configurationActivity);
        assertTrue(Configuration.difficultyLevel(button));
    }
}