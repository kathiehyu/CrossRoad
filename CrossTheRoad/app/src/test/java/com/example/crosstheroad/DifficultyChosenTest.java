package com.example.crosstheroad;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.RadioButton;

/**
 * This class checks that a character has been chosen
 */
public class DifficultyChosenTest {
    RadioButton button1 = null;
    @Test
    public void testDifficulty() {assertFalse(Configuration.difficultyLevel(button1));}
}
