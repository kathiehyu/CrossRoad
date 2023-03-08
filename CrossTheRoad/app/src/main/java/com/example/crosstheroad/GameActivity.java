package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * This class will process the game's activity.
 */
public class GameActivity extends AppCompatActivity {
    private GameView gameView;
    private Movement movePosition;
    private static int score;
    private static int currentRow;
    private static int highestRow;
    private TextView scoreDisplay;
    private int riverScore = 5;
    private int roadScore = 6;
    private int safeScore = 3;
    private int goalScore = 8;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("created instance state");
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        FrameLayout game = new FrameLayout(this);
        gameView = new GameView(this);
        // GridLayout buttons = new GridLayout(this);
        LinearLayout scoreContainer = new LinearLayout(this);
        score = 0;
        currentRow = 11;
        scoreDisplay = new TextView(this);

        LinearLayout buttons = new LinearLayout(this);

        Button up = new Button(this);
        Button down = new Button(this);
        Button left = new Button(this);
        Button right = new Button(this);

        up.setWidth(200);
        up.setText("UP");

        down.setWidth(200);
        down.setText("DOWN");

        //         starting position
        int x = Background.getTileLength()
                * (Background.getScreenX() / Background.getTileLength() / 2);
        int y = Background.getTileLength()
                * (Background.getScreenY() / Background.getTileLength() - 1);
        movePosition.setCharX(x);
        movePosition.setCharY(y);

        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);

        game.setLayoutParams(frameParams);

        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(
                ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);

        buttons.setLayoutParams(gridParams);
        buttons.addView(up);
        buttons.addView(down);
        buttons.addView(left);
        buttons.addView(right);
        buttons.setGravity(Gravity.BOTTOM);

        game.addView(gameView);
        game.addView(buttons);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movePosition.setCharY(gameView.getCharY()
                        - Background.getTileLength());
                currentRow--;
                if (currentRow < highestRow) {
                    // find what row you just passed (what row you are on)
                    if (Background.getRiverRows().contains(currentRow)) {
                        score += riverScore;
                    } else if (Background.getRoadRows().contains(currentRow)) {
                        score += roadScore;
                    } else if (Background.getSafeRows().contains(currentRow)) {
                        score += safeScore;
                    } else if (Background.getGoalRows().contains(currentRow)) {
                        score += goalScore;
                    }
                    scoreDisplay.setText(score);
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movePosition.setCharY(gameView.getCharY()
                        + Background.getTileLength());
                currentRow++;
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movePosition.setCharX(gameView.getCharX()
                        - Background.getTileLength());
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movePosition.setCharX(gameView.getCharX()
                        + Background.getTileLength());
            }
        });

        setContentView(game);
        // crashes the app??? cries
//        scoreDisplay.setText(score);
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
