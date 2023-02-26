package com.example.crosstheroad;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.RadioButton;

/**
 * This class check for edge cases in configuration class
 */
public class PlayerNameTest {

    @Test
    public void checkName(){
        String test = "";
        assertFalse(Configuration.verifyName(test));
    }

    String name1 = " ";
    @Test
    public void spaceName() {assertFalse(Configuration.verifyName(name1));}

    String name2 = "123";
    @Test
    public void testNameNumber() {assertTrue(Configuration.verifyName(name2));}

    String name3 = "!@#";
    @Test
    public void testNameSpecialCharacter() {assertTrue(Configuration.verifyName(name3));}

    String name4 = "Tam";
    @Test
    public void testNameNormal() {assertTrue(Configuration.verifyName(name4));}
}
