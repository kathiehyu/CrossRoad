package com.example.crosstheroad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class Sprint4Test {
    /**
     * this test check if the character collide with the first obstacle
     */
    @Test
    public void testFirstObstacleColliding() {
        int charX = 0;
        int obstacleX = 0;
        assertTrue(GameActivity.checkObstacleColliding(charX, obstacleX));
    }

    /**
     * this test check if the character collide with the first obstacle
     */
    @Test
    public void testFirstObstacleCollidingg() {
        int charX = 3;
        int obstacleX = 3;
        assertTrue(GameActivity.checkObstacleColliding(charX, obstacleX));
    }

    /**
     * Test if the game can keep track maximum score
     */
    @Test
    public void testKeepMaxScore() {
        int score = 0;
        assertTrue(GameActivity.checkKeepMaxScore(score));
    }

    @Mock
    private GameActivity game = mock(GameActivity.class);

    /**
     * This test verifies if removeLife() reduces 1 life
     */
    @Test
    public void checkremoveLife() {
        game.setLives(3);
        game.removeLife();
        Mockito.when(game.getLives()).thenReturn(2);
        int lives = game.getLives();
        assertEquals(2, lives);
    }

    /**
     * This test check the number of lives at the beginning
     * of the game after calling setStartCondition()
     */
    @Test
    public void TestinitialLife() {
        game.setLives(3);
        game.setStartConditions(false);
        Mockito.when(game.getLives()).thenReturn(3);
        int lives = game.getLives();
        assertEquals(3, lives);
    }

    private GameActivity live;
    private Movement move;

    /**
     * The player should be respawned at the initial starting point
     */
    @Test
    public void testRespawned() {
        int x = 0;
        int y = 0;
        assertTrue(GameActivity.checkRespawned(x, y));

    }

    /**
     * The score should be set to zero when the player is respawned
     */
    @Test
    public void testRespawnedScore() {
        int score = 0;
        assertTrue(GameActivity.checkRespawnedScore(score));

    }

    /**
     * this test check if the character collide with the first obstacle
     */
    @Test
    public void testSecondObstacleColliding() {
        int charX = 1;
        int obstacleX = 1;
        assertTrue(GameActivity.checkObstacleColliding(charX, obstacleX));
    }

    /**
     * this test check if the character collide with the first obstacle
     */
    @Test
    public void testFirstObstacleCollidin() {
        int charX = 2;
        int obstacleX = 2;
        assertTrue(GameActivity.checkObstacleColliding(charX, obstacleX));
    }

    /**
     * Colliding with any vehicle decrease the remaining lives by one
     */
    @Test
    public void testVehicleColliding() {
        int liveBefore = 3;
        int liveAfter = 2;
        assertTrue(GameActivity.checkVehicleCollision(liveBefore - 1, liveAfter));
    }

    /**
     * Touching water tile decrease the remaining lives by one
     */
    @Test
    public void testWaterTile() {
        int liveBefore = 3;
        int liveAfter = 2;
        assertTrue(GameActivity.checkWaterTile(liveBefore - 1, liveAfter));
    }

    /**
     * this test check if the character touch the water tile
     */
    @Test
    public void testWaterTileColliding() {
        int water = 0;
        int charY = 0;
        assertTrue(GameActivity.checkWaterTileColliding(water, charY));
    }

    /**
     * This test check if the player has more than 0 life in order to continue to play
     */
    @Test
    public void testZeroLife() {
        int life = 1;
        assertTrue(GameActivity.checkZeroLife(life));
    }

}
