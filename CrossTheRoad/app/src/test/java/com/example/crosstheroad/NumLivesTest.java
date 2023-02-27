package com.example.crosstheroad;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumLivesTest {
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

}
