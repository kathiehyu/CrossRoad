package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * This class will display the first map the player will see. (activity_game_screen.xml)
 * Including: starting point and starting lives,
 * player name and character sprite, chosen difficulty.
 */
public class GameScreen extends AppCompatActivity {
    // future implementation: change to high score?
    protected static int points;
    private Button start;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // display name
        TextView displayName = findViewById(R.id.playerName);
        displayName.setText(Configuration.inputName);

        // display difficulty
        String diff = (String) Configuration.selectedDifficulty.getText();
        TextView displayDiff = findViewById(R.id.difficultyDisplay);
        displayDiff.setText(diff);

        //display beginning points
        TextView pointsDisplay = findViewById(R.id.pointsDisplay);
        pointsDisplay.setText(Integer.toString(points));

        //display number of lives
        TextView numLives = findViewById(R.id.lives);
        View inflatedView = getLayoutInflater().inflate(R.layout.activity_configuration, null);

        if (checkDifferentLife(Configuration.selectedDifficulty.getId(),
                inflatedView.findViewById(R.id.eas).getId())) {
            numLives.setText("1");
        } else if (checkDifferentLife(Configuration.selectedDifficulty.getId(),
                inflatedView.findViewById(R.id.med).getId())) {
            numLives.setText("2");
        } else {
            numLives.setText("3");
        }

        //display character sprite
        ImageView charact = findViewById(R.id.chosenChar);
        if (Configuration.charButton.getId() == R.id.character1) {
            charact.setImageDrawable(Configuration.charButton
                    .getResources().getDrawable(R.drawable.character_1));
        } else if (Configuration.charButton.getId() == R.id.character2) {
            charact.setImageDrawable(Configuration.charButton
                    .getResources().getDrawable(R.drawable.c2));
        } else {
            charact.setImageDrawable(Configuration.charButton
                    .getResources().getDrawable(R.drawable.character_3));
        }

        //start game button
        start = (Button) findViewById(R.id.start_game);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfiguration();
            }
        });
    }

    public void openConfiguration() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public static boolean checkDifferentLife(int id1, int id2) {
        if (id1 == id2) {
            return true;
        }
        return false;
    }

}