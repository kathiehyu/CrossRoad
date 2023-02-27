package com.example.crosstheroad;

import androidx.test.core.app.ApplicationProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InBoundsTest {

    private GameView gameView;
    private int screenWidth;
    private int screenHeight;

    @Before
    public void setUp() {
        screenWidth = 1080;
        screenHeight = 1920;
        gameView = new GameView(ApplicationProvider.getApplicationContext(), screenWidth, screenHeight);
    }

    @Test
    public void testCharacterStaysInBounds() {
        int maxIterations = 100;
        int minY = 0;
        int maxY = screenHeight - gameView.character.height;
        gameView.character.y = minY;

        for (int i = 0; i < maxIterations; i++) {
            gameView.update();
            Assert.assertTrue(gameView.character.y >= minY);
            Assert.assertTrue(gameView.character.y <= maxY);
        }

        gameView.character.y = maxY;
        for (int i = 0; i < maxIterations; i++) {
            gameView.update();
            Assert.assertTrue(gameView.character.y >= minY);
            Assert.assertTrue(gameView.character.y <= maxY);
        }
    }
}
