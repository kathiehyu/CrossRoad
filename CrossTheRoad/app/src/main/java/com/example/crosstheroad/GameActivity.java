package com.example.crosstheroad;

import static com.example.crosstheroad.Background.screenX;
import static com.example.crosstheroad.Background.screenY;
import static com.example.crosstheroad.Background.tileLength;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;

/**
 * This class will process the game's activity.
 */
public class GameActivity extends AppCompatActivity {
    private GameView gameView;
    private Character character = GameView.character;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("created instance state");
//        setContentView(R.layout.activity_game_activity);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        System.out.println("CREAETING BACKGROUND");
        Background bg = new Background(getResources(), this);
        Character character = new Character(MainActivity.screenX, MainActivity.screenY, getResources());

        gameView = new GameView(this, point.x, point.y);


//        setContentView(gameView);
        setContentView(R.layout.activity_game_activity);
        BitmapDrawable bmd = new BitmapDrawable(Background.background);
        findViewById(R.id.grid).setBackground(bmd);

        BitmapDrawable bmd2 = new BitmapDrawable(Character.character);
        ImageView charDisplay = findViewById(R.id.characterDisplay);
        charDisplay.setImageDrawable(bmd2);
        charDisplay.setX(character.x);
        charDisplay.setY(character.y);

        findViewById(R.id.upButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveUp(character, charDisplay);
                charDisplay.setX(character.x);
                charDisplay.setY(character.y);
            }
        });
        findViewById(R.id.downButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveDown(character, charDisplay);
                charDisplay.setX(character.x);
                charDisplay.setY(character.y);
            }
        });
        findViewById(R.id.leftButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLeft(character, charDisplay);
                charDisplay.setX(character.x);
                charDisplay.setY(character.y);
            }
        });
        findViewById(R.id.rightButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveRight(character, charDisplay);
                charDisplay.setX(character.x);
                charDisplay.setY(character.y);
            }
        });
    }

    private void moveUp(Character character, ImageView charDisplay) {
        character.y -= tileLength;
    }
    private void moveDown(Character character, ImageView charDisplay) {
        character.y += tileLength;
    }
    private void moveLeft(Character character, ImageView charDisplay) {
        character.x -= tileLength;
    }
    private void moveRight(Character character, ImageView charDisplay) {
        character.x += tileLength;
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("PAUSING");
        gameView.pause();
        System.out.println("paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUMING");
        gameView.resume();
        System.out.println("resumed");
    }
}
