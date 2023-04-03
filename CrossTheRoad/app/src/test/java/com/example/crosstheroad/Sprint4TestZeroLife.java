package com.example.crosstheroad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class Sprint4TestZeroLife {
    /**
     * This test check if the player has more than 0 life in order to continue to play
     */
    @Test
    public void testZeroLife(){
        int life = 1;
        assertTrue(GameActivity.checkZeroLife(life));
    }
}
