package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * This class will display the first map the player will see. (activity_game_screen.xml)
 * Including: starting point and starting lives, player name and character sprite, chosen difficulty.
 */
public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        TextView displayName = findViewById(R.id.playerName);
        displayName.setText(Configuration.editName);
        String diff = (String) Configuration.difficultyButton.getText();
        TextView displayDiff = findViewById(R.id.difficultyDisplay);
        displayDiff.setText(diff);
        TextView numLives = findViewById(R.id.lives);
        View inflatedView = getLayoutInflater().inflate(R.layout.activity_configuration, null);
        System.out.println(Configuration.difficultyButton.getId());
        System.out.println(inflatedView.findViewById(R.id.eas).getId());
        if (Configuration.difficultyButton.getId() == (inflatedView.findViewById(R.id.eas).getId())) {
            numLives.setText("3");
        } else if (Configuration.difficultyButton.getId() == (inflatedView.findViewById(R.id.med)).getId()) {
            numLives.setText("2");
        } else {
            numLives.setText("1");
        }
    }
}