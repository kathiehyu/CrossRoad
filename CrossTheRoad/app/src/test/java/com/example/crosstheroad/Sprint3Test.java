package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.Button;
import android.widget.RadioButton;


public class Sprint3Test {

  /*  @Test
    public void scoreOrigin() {
        GameActivity.setCurrentRow(15);
        GameActivity.updateScore();
        assert GameActivity.getScore() == 0;
    }

    *//**
     * From origin, if moving up 1 row, score + 4
     *//*
    @Test
    public void moveUpFromOrigin() {
        GameActivity.setCurrentRow(14);
        GameActivity.updateScore();
        assert GameActivity.getScore() == 4;
    }

    *//**
     * test 3
     *//*

    public void moveUpTwiceFromOrigin() {
        GameActivity.setCurrentRow(14);
        GameActivity.updateScore();
        GameActivity.setCurrentRow(13);
        GameActivity.updateScore();
        assert GameActivity.getScore() == 7;
    }

    *//**
     * test 4
     *//*
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

    *//**
     * test 5
     *//*

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

    *//**
     * test 6
     *//*

    @Test
    public void testUpdateScore() {
        // Test the initial score
        int initialScore = GameActivity.updateScore();
        assertEquals(0, initialScore);
    }

    *//**
     * test 7
     *//*
    public void testUpdateScore() {
        GameActivity.setCurrentRow(8);
        int expectedScore = 0;
        int actualScore = GameActivity.updateScore();
        assertEquals(expectedScore, actualScore);
    }

    *//**
     * test 8
     *//*
    @Test
    public void testUpdateScore() {
        GameActivity.setCurrentRow(8);
        int expectedScore = 0;
        int actualScore = GameActivity.updateScore();
        assertEquals(expectedScore, actualScore);
    }

    *//**
     * test 9
     *//*
    @Test
    public void testUpdateScore() {
        GameActivity.currentRow = 9;
        GameActivity.highestRow = 10;
        int initialScore = GameActivity.getScore();

        GameActivity.updateScore();

        assertNotEquals(initialScore + GameActivity.safeScore, GameActivity.getScore());
    }

    *//**
     * test 10
     *//*

    @Test
    public void testUpdateScore() {
        GameActivity.currentRow = 8;
        GameActivity.highestRow = 15;
        int expectedScore = 0;

        int actualScore = GameActivity.updateScore();

        assertEquals(expectedScore, actualScore);
    }

    *//**
     * test 11
     *//*
    @Test
    public void testCharacterChoice() {
        assertFalse(Configuration.characterChoice(null));
    }


    *//**
     * test 12
     *//*
    @Test
    public void testDifficultyLevel() {
        RadioButton radioButton = new RadioButton(null);
        assertFalse(Configuration.difficultyLevel(null));
    }

*/


}
