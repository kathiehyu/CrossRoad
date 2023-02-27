package com.example.crosstheroad;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.RadioButton;

/**
 * This class check for edge cases in configuration class
 */
public class ConfigScreenTest {

<<<<<<< Updated upstream
=======

    // unit Test 1: check name
>>>>>>> Stashed changes
    @Test
    public void checkEmtpyName(){
        String test = "";
        assertFalse(Configuration.verifyName(test));
    }
    @Test
    public void checkNameWithWhiteSpace() {
        String test = " ";
        assertFalse(Configuration.verifyName(test));}
    @Test
    public void checkNamewithNull() {
        String test = null;
        assertFalse(Configuration.verifyName(test));
    }


    //Unit Test 2: check different lives base on the chosen difficulty
    @Test
    public void testDifficultyLevel1(){
        int level = 1;
        int diffButton = 1;
        assertTrue(GameScreen.checkDifferentLife(level, diffButton));
    }
    @Test
    public void testDifficultyLevel2(){
        int level = 2;
        int diffButton = 2;
        assertTrue(GameScreen.checkDifferentLife(level, diffButton));
    }
    @Test
    public void testDifficultyLevel3(){
       int level = 3;
       int diffButton = 3;
       assertTrue(GameScreen.checkDifferentLife(level, diffButton));
    }

    // Unit Test 3:
    RadioButton button1 = null;
    @Test
    public void testDifficulty() {assertFalse(Configuration.difficultyLevel(button1));}

    RadioButton button2 = null;
    @Test
    public void testCharacter() {assertFalse(Configuration.characterChoice(button2));}
}
