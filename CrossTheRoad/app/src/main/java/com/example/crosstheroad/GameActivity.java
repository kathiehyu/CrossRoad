package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ObjectAnimator;
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
 * This class will process the gameContainer's activity.
 */
public class GameActivity extends AppCompatActivity {
    private GameView gameView;
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
        System.out.println("Successfully created GameActivity");
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        FrameLayout gameContainer = new FrameLayout(this);
        gameView = new GameView(this);
        LinearLayout scoreContainer = new LinearLayout(this);

        setStartConditions();

        scoreDisplay = new TextView(this);
        scoreDisplay.setId(R.id.reservedNamedID);
        scoreDisplay.setTextSize(50);
        scoreContainer.addView(scoreDisplay);

        LinearLayout buttons = new LinearLayout(this);

        Button up = new Button(this);
        Button down = new Button(this);
        Button left = new Button(this);
        Button right = new Button(this);

        configureButtons(up, down, left, right);

        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);

        gameContainer.setLayoutParams(frameParams);

        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(
                ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);

        buttons.setLayoutParams(gridParams);
        buttons.addView(up);
        buttons.addView(down);
        buttons.addView(left);
        buttons.addView(right);
        buttons.setGravity(Gravity.BOTTOM);

        gameContainer.addView(gameView);
        gameContainer.addView(scoreContainer);
        gameContainer.addView(buttons);

        System.out.println("CREATING WATERBALL");
        Jessie wb1 = new Jessie(getResources(), this, 6000, MainActivity.getScreenX());
        System.out.println("WATERBALL CREATED");

        System.out.println(wb1.graphic.getWidth());
        gameContainer.addView(wb1.graphic);
        animation(wb1);

        setContentView(gameContainer);
        // crashes the app??? cries
        scoreDisplay.setText(Integer.toString(score));
    }

    private void animation(Jessie wb) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(wb.graphic, "translationX", 1300f);
        animator.setDuration(wb.duration);
        animator.start();
        System.out.println("ANIMATOR STARTED");
    }

//    private void setTranslationX(int x) {
//        MainActivity.getScreenX();
//    }

    private void setStartConditions() {
        int x = Background.getTileLength()
                * (MainActivity.getScreenX() / Background.getTileLength() / 2);
        int y = Background.getTileLength()
                * (MainActivity.getScreenY() / Background.getTileLength() - 2);
        Movement.setCharX(x);
        Movement.setCharY(y);

        score = 0;
        currentRow = 11;
        highestRow = 11;
    }

    private void configureButtons(Button up, Button down, Button left, Button right) {
        up.setWidth(150);
        up.setText("UP");

        down.setWidth(150);
        down.setText("DOWN");

        left.setWidth(150);
        left.setText("LEFT");

        right.setWidth(150);
        right.setText("RIGHT");

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y = gameView.getCharY() - Background.getTileLength();
                Movement.setCharY(y);
                if (Movement.validateMovement(gameView.getCharX(), y)) {
                    currentRow--;
                    updateScore();
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y = gameView.getCharY() + Background.getTileLength();
                Movement.setCharY(y);
                if (Movement.validateMovement(gameView.getCharX(), y)) {
                    currentRow++;
                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movement.setCharX(gameView.getCharX()
                        - Background.getTileLength());
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movement.setCharX(gameView.getCharX()
                        + Background.getTileLength());
            }
        });
    }

    private int updateScore() {
        System.out.println("CURRENT ROW: " + Integer.toString(currentRow));
        System.out.println("HIGHEST ROW: " + Integer.toString(highestRow));
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
            highestRow = currentRow;
            scoreDisplay.setText(Integer.toString(score));
        }
        System.out.println("SCORE: " + Integer.toString(score));
        return score;
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
