package com.example.crosstheroad;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.RadioButton;

/**
 * This class checks that a character has been chosen
 */
public class CharacterChosenTest {

    RadioButton button2 = null;
    @Test
    public void testCharacter() {assertFalse(Configuration.characterChoice(button2));}
}
