package com.example.crosstheroad;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        // display name
        TextView displayName = findViewById(R.id.endGameName);
        displayName.setText(Configuration.inputName);

        //display final score
        TextView pointsDisplay = findViewById(R.id.finalScoreDisplay);
        pointsDisplay.setText(Integer.toString(GameActivity.getScore()));

        Button restart = (Button) findViewById(R.id.restart_game);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameActivity();
            }
        });

        Button exit = (Button) findViewById(R.id.exit_game);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });
    }

    private void openGameActivity() {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }
}
