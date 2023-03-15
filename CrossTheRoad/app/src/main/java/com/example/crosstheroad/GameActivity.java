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
    private static int score = 0;
    private static int currentRow = 15;
    private static int highestRow = 15;
    private TextView scoreDisplay;
    private static int safeScore = 1;
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

        createRoadObstacles(gameContainer);

        setContentView(gameContainer);
        // crashes the app??? cries
        scoreDisplay.setText(Integer.toString(score));
    }

    private void setStartConditions() {
        int x = Background.getTileLength()
                * (MainActivity.getScreenX() / Background.getTileLength() / 2);
        int y = Background.getTileLength()
                * (MainActivity.getScreenY() / Background.getTileLength() - 2);
        Movement.setCharX(x);
        Movement.setCharY(y);

        score = 0;
        currentRow = 15;
        highestRow = 15;
    }

    private void createRoadObstacles(FrameLayout gameContainer) {
        //Jessie
        Jessie jessie = new Jessie(getResources(), this, 5000, Background.getTileLength() * 9);
        gameContainer.addView(jessie.graphic);
        jessie.setAnimation(0);

        //Jessie2
        Jessie jessie2 = new Jessie(getResources(), this, 5000, Background.getTileLength() * 9);
        gameContainer.addView(jessie2.graphic);
        jessie2.setAnimation(3000);



        //James
        James james = new James(getResources(), this, 6000, Background.getTileLength() * 10);
        gameContainer.addView(james.graphic);
        james.setAnimation(0);

        //James2
        James james2 = new James(getResources(), this, 6000, Background.getTileLength() * 10);
        gameContainer.addView(james2.graphic);
        james2.setAnimation(2000);




        //Meowth
        Meowth meowth = new Meowth(getResources(), this, 3000, Background.getTileLength() * 11);
        gameContainer.addView(meowth.graphic);
        meowth.setAnimation(0);

        //Meowth2
        Meowth meowth2 = new Meowth(getResources(), this, 3000, Background.getTileLength() * 11);
        gameContainer.addView(meowth2.graphic);
        meowth2.setAnimation(3000);





        //Wobuffet
        Wobuffet wobuffet = new Wobuffet(getResources(), this, 6000, Background.getTileLength() * 12);
        gameContainer.addView(wobuffet.graphic);
        wobuffet.setAnimation(1000);

        //Wobuffet2
        Wobuffet wobuffet2 = new Wobuffet(getResources(), this, 6000, Background.getTileLength() * 12);
        gameContainer.addView(wobuffet2.graphic);
        wobuffet2.setAnimation(1500);

        //Wobuffet3
        Wobuffet wobuffet3 = new Wobuffet(getResources(), this, 6000, Background.getTileLength() * 12);
        gameContainer.addView(wobuffet3.graphic);
        wobuffet3.setAnimation(2000);





        //Grookey
        Grookey grookey = new Grookey(getResources(), this, 5000, Background.getTileLength() * 13);
        gameContainer.addView(grookey.graphic);
        grookey.setAnimation(0);

        //Grookey2
        Grookey grookey2 = new Grookey(getResources(), this, 5000, Background.getTileLength() * 13);
        gameContainer.addView(grookey2.graphic);
        grookey2.setAnimation(1000);

        //Grookey3
        Grookey grookey3 = new Grookey(getResources(), this, 5000, Background.getTileLength() * 13);
        gameContainer.addView(grookey3.graphic);
        grookey3.setAnimation(2000);


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
                boolean checkMoveUp = Movement.moveUp();
                if (checkMoveUp) {
                    currentRow--;
                    updateScore();
                    scoreDisplay.setText(Integer.toString(score));
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkMoveDown = Movement.moveDown();
                if (checkMoveDown) {
                    currentRow++;
                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movement.moveLeft();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movement.moveRight();
            }
        });
    }

    public static int updateScore() {
        System.out.println("CURRENT ROW: " + Integer.toString(currentRow));
        System.out.println("HIGHEST ROW: " + Integer.toString(highestRow));
        if (currentRow < highestRow) {

            if (currentRow == 10) {
                score += 4; // Jessi
            } else if (currentRow == 11) {
                score += 3; // James
            } else if (currentRow == 12) {
                score += 1; // Meowth
            } else if (currentRow == 13) {
                score += 1; // Wobuffet
            } else if (currentRow == 14) {
                score += 2; // Grookey
            }

            highestRow = currentRow;
        }
        System.out.println("SCORE: " + Integer.toString(score));
        return score;
    }

    /**
     * This method returns the current score
     * @return current score
     */
    public static int getScore() {
        return score;
    }

    /**
     * This method sets the current row
     * @param row current row
     */
    public static void setCurrentRow(int row) {
        currentRow = row;
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
