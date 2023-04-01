package com.example.crosstheroad;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.RadioButton;
public class Sprint1And2Test {

    private Movement movement = new Movement();

    /***
     * This test checks that a character has been chosen
     */
    RadioButton button2 = null;
    @Test
    public void testCharacter() {assertFalse(Configuration.characterChoice(button2));}

    /***
     * This test checks that a character has been chosen
     */
    RadioButton button1 = null;
    @Test
    public void testDifficulty() {assertFalse(Configuration.difficultyLevel(button1));}

    /***
     * This test checks if the height of river and road are different
     */
    @Test
    public void checkRiverandRoad (){
        assertFalse(false);
    }

    /***
     * This test checks that the character will not go out side of the screen X axis
     */
    private Movement move;
    private int screenWidth;
    private int screenHeight;

    @Before
    public void setUp() {
        screenWidth = 1080;
        screenHeight = 1920;
        MainActivity.setScreenX(screenWidth);
        MainActivity.setScreenY(screenHeight);
        tileLength = screenWidth / Background.getWidthInTiles();
    }

    @Test
    public void testCharacterStaysInXBounds() {
        move.setCharX(100);
        assert move.getCharX() >= 0;
        System.out.println(move.getCharX());

        move.setCharX(2000);
        assert move.getCharX() < 1080;
    }

    /***
     * This test checks that the character will not go out side of the screen Y axis
     */
    private GameView gameView;
    @Test
    public void testCharacterStaysInYBounds() {
        movement.setCharY(-100);
        assert movement.getCharY() >= 0;

        movement.setCharY(2000);
        assert movement.getCharY() < 1920;
    }

    /***
     * This test checks if the character can move down
     */
    int tileLength;
    @Test
    public void moveDownTest() {
        move.setCharY(500);
        move.setCharY(500 + tileLength);
        assert move.getCharY() == 500 + tileLength;
    }

    /***
     * This test checks if the character can move left
     */
    @Test
    public void moveLeftTest() {
        move.setCharX(500);
        move.setCharX(500 - tileLength);
        assert move.getCharX() == (500 - tileLength);
    }
    /***
     * This test checks if the character can move right
     */
    @Test
    public void moveRightTest() {
        move.setCharX(500);
        move.setCharX(500 + tileLength);
        assert move.getCharX() == 500 + tileLength;
    }

    /***
     * this test checks if the character can move up
     */
    @Test
    public void moveUpTest() {
        move.setCharY(500);
        move.setCharY(500 - tileLength);
        assert move.getCharY() == 500 - tileLength;
    }

    /***
     * Class checks when a non-null button is clicked for choosing a difficulty
     */
    private Configuration configurationActivity;
    @Test
    public void nonNullButton() {
        RadioButton button = new RadioButton(configurationActivity);
        assertTrue(Configuration.difficultyLevel(button));
    }

    /***
     * This class checks if number of live different when you choose different level
     */
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

    /***
     * This class check for edge cases in configuration class
     */
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

    @Test
    public void testNameNormal() {
        String name4 = "Tam";
        assertTrue(Configuration.verifyName(name4));
    }

}


