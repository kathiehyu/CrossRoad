package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
        // display name
        TextView displayName = findViewById(R.id.playerName);
        displayName.setText(Configuration.editName);

        // display difficulty
        String diff = (String) Configuration.difficultyButton.getText();
        TextView displayDiff = findViewById(R.id.difficultyDisplay);
        displayDiff.setText(diff);

        //display number of lives
        TextView numLives = findViewById(R.id.lives);
        View inflatedView = getLayoutInflater().inflate(R.layout.activity_configuration, null);
        if (Configuration.difficultyButton.getId() == (inflatedView.findViewById(R.id.eas).getId())) {
            numLives.setText("3");
        } else if (Configuration.difficultyButton.getId() == (inflatedView.findViewById(R.id.med)).getId()) {
            numLives.setText("2");
        } else {
            numLives.setText("1");
        }

        //display character sprite
        ImageView charact = findViewById(R.id.chosenChar);
        // following line requires API 23 but our min is 21 :(
//        charact.setImageDrawable(Configuration.charButton.getButtonDrawable());

        if (Configuration.charButton.getId() == R.id.character1) {
            charact.setImageDrawable(Configuration.charButton.getResources().getDrawable(R.drawable.character_1));
        } else if (Configuration.charButton.getId() == R.id.character2) {
            charact.setImageDrawable(Configuration.charButton.getResources().getDrawable(R.drawable.c2));
        } else {
            charact.setImageDrawable(Configuration.charButton.getResources().getDrawable(R.drawable.character_3));
        }
    }
}