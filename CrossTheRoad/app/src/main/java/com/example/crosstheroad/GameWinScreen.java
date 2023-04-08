package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameWinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win_screen);

        //display final score
        TextView pointsDisplay = findViewById(R.id.finalScoreDisplay);
        System.out.println("FINAL SCORE? " + Integer.toString(GameActivity.getGameScore()));
        pointsDisplay.setText(Integer.toString(GameActivity.getGameScore()));

        Button restart = (Button) findViewById(R.id.restart_game);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfiguration();
            }
        });

        Button exit = (Button) findViewById(R.id.exit_game);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
    }

    private void openConfiguration() {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }
}
