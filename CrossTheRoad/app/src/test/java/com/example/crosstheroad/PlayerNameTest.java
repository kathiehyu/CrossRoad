package com.example.crosstheroad;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.RadioButton;

/**
 * This class check for edge cases in configuration class
 */
public class PlayerNameTest {

    // unit Test 1: check name
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
