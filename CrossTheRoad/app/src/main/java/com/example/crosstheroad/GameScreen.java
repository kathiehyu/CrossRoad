package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * This class will display the first map the player will see. (activity_game_screen.xml)
 * Including: starting point and starting lives, player name and character sprite, chosen difficulty.
 */
public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
    }
}