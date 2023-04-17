package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class Sprint5checkScoreGoalTile {
    int row = 1; // goal tile row
    @Test
    public void checkGoalTileScore() {
        int score = 10;
        assertTrue(score == GameActivity.checkScoreGoalTile(row));
    }

}
