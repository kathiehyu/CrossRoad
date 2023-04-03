package com.example.crosstheroad;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class Sprint4TestRespawnedScore {
    private GameActivity live;
    private Movement move;

    /**
     * The score should be set to zero when the player is respawned
     */
    @Test
    public void testRespawnedScore(){
        int score = 0;
        assertTrue(GameActivity.checkRespawnedScore(score));

    }
}
