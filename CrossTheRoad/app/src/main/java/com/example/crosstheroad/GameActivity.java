package com.example.crosstheroad;

import static com.example.crosstheroad.Background.screenX;
import static com.example.crosstheroad.Background.screenY;
import static com.example.crosstheroad.Background.tileLength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //        setContentView(R.layout.activity_game_activity);
        //        Point point = new Point();
        //        getWindowManager().getDefaultDisplay().getSize(point);

        //        System.out.println("CREATING BACKGROUND");
        //        Background bg = new Background(getResources(), this);
        //        Character character = new Character(MainActivity.screenX,
        //        MainActivity.screenY, getResources());

        FrameLayout game = new FrameLayout(this);
        gameView = new GameView(this);
        // GridLayout buttons = new GridLayout(this);
        LinearLayout buttons = new LinearLayout(this);

        Button up = new Button(this);
        Button down = new Button(this);
        Button left = new Button(this);
        Button right = new Button(this);

        up.setWidth(200);
        up.setText("UP");

        down.setWidth(200);
        down.setText("DOWN");

        left.setWidth(200);
        left.setText("LEFT");

        right.setWidth(200);
        right.setText("RIGHT");

        //         starting position
        int x = Background.tileLength * ((screenX / Background.tileLength) / 2);
        int y = Background.tileLength * (screenY / Background.tileLength - 1);
        gameView.setCharX(x);
        gameView.setCharY(y);

        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);
        //        frameParams.gravity = Gravity.START;
        game.setLayoutParams(frameParams);

        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(
                ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
        //        gridParams.setGravity(Gravity.START);
        //        gridParams.gravity = Gravity.START;
        buttons.setLayoutParams(gridParams);

        buttons.addView(up);
        buttons.addView(down);
        buttons.addView(left);
        buttons.addView(right);

        game.addView(gameView);
        game.addView(buttons);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.setCharY(gameView.getCharY() - tileLength);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.setCharY(gameView.getCharY() + tileLength);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.setCharX(gameView.getCharX() - tileLength);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.setCharX(gameView.getCharX() + tileLength);
            }
        });

        setContentView(game);
        //        setContentView(gameView);
        //        setContentView(R.layout.activity_game_activity);
        //        BitmapDrawable bmd = new BitmapDrawable(Background.background);
        //        findViewById(R.id.grid).setBackground(bmd);

        //        BitmapDrawable bmd2 = new BitmapDrawable(Character.character);
        //        ImageView charDisplay = findViewById(R.id.characterDisplay);
        //        charDisplay.setImageDrawable(bmd2);
        //        charDisplay.setX(character.x);
        //        charDisplay.setY(character.y);

        //        findViewById(R.id.upButton).setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                moveUp(character, charDisplay);
        //            }
        //        });
        //        findViewById(R.id.downButton).setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                moveDown(character, charDisplay);
        //            }
        //        });
        //        findViewById(R.id.leftButton).setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                moveLeft(character, charDisplay);
        //            }
        //        });
        //        findViewById(R.id.rightButton).setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                moveRight(character, charDisplay);
        //            }
        //        });
    }

    //    private void moveUp(Character character, ImageView charDisplay) {
    //        if (character.y - tileLength >= 0) {
    //            character.y -= tileLength;
    //            charDisplay.setX(character.x);
    //            charDisplay.setY(character.y);
    //        }
    //    }
    //    private void moveDown(Character character, ImageView charDisplay) {
    //
    //        if (character.y + tileLength + tileLength <= MainActivity.screenY){
    //            character.y += tileLength;
    //            charDisplay.setX(character.x);
    //            charDisplay.setY(character.y);
    //        }
    //    }
    //    private void moveLeft(Character character, ImageView charDisplay) {
    //        if (character.x - tileLength >= 0) {
    //            character.x -= tileLength;
    //            charDisplay.setX(character.x);
    //            charDisplay.setY(character.y);
    //        }
    //    }
    //    private void moveRight(Character character, ImageView charDisplay) {
    //        if (character.x + tileLength + tileLength <= MainActivity.screenX){
    //            character.x += tileLength;
    //            charDisplay.setX(character.x);
    //            charDisplay.setY(character.y);
    //        }
    //    }

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
