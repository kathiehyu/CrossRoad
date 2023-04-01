package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * This class will process the gameContainer's activity.
 */
public class GameActivity extends AppCompatActivity {
    private GameView gameView;
    private static int score = 0;

    private static int lives = GameScreen.getLives();

    private static int highestRow;

    private TextView scoreDisplay;
    private static TextView livesDisplay;
    private static int safeScore = 1;
    private int goalScore = 8;

    private String packageName;

    private static Movement movement;

    private static Context context;

    public static Movement getMovement() {
        return movement;
    }

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Successfully created GameActivity");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        context = GameActivity.this;


        FrameLayout gameContainer = new FrameLayout(this);
        gameView = new GameView(this);
        LinearLayout scoreContainer = new LinearLayout(this);

        movement = gameView.getMovement();

        setStartConditions(false);

        scoreDisplay = new TextView(this);
        scoreDisplay.setId(R.id.reservedScoreID);
        scoreDisplay.setTextSize(50);

        livesDisplay = new TextView(this);
        livesDisplay.setId(R.id.reservedLivesID);
        livesDisplay.setTextSize(50);

        View filler = new View(this);

        scoreContainer.addView(scoreDisplay);
//        scoreContainer.addView(filler);
        scoreContainer.addView(livesDisplay);
        scoreContainer.setOrientation(LinearLayout.HORIZONTAL);

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
        livesDisplay.setText(Integer.toString(lives));
        livesDisplay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println("LIVES CHANGED");
                System.out.println(livesDisplay.getText());
                System.out.println((livesDisplay.getText().charAt(0) == '0'));
                if (livesDisplay.getText().charAt(0) == '0') {
                    System.out.println("ATTEMPTING TO START GAME OVER");
                    Intent intent = new Intent (context, GameOverScreen.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void setStartConditions(boolean loseLife) {
        int x = Background.getTileLength()
                * (MainActivity.getScreenX() / Background.getTileLength() / 2);
        int y = Background.getTileLength()
                * (MainActivity.getScreenY() / Background.getTileLength() - 2);

        System.out.println("SETTING TO START CONDITIONS");
        movement.setCharX(x);
        movement.setCharY(y);

        score = 0;
        movement.setRow(15);
        highestRow = 15;
        if (loseLife) {
            removeLife();
        }
    }

    public void createJessies(FrameLayout gameContainer) {
        //Jessie
        Jessie jessie = new Jessie(getResources(), this, 7000, Background.getTileLength() * 9);
        gameContainer.addView(jessie.getGraphic());
        jessie.setAnimation(0);

        //Jessie2
        Jessie jessie2 = new Jessie(getResources(), this, 7000,Background.getTileLength() * 9);
        gameContainer.addView(jessie2.getGraphic());
        jessie2.setAnimation(3000);
    }

    private void createRoadObstacles(FrameLayout gameContainer) {
        createJessies(gameContainer);

        //James
        James james = new James(getResources(), this, 8000, MainActivity.getScreenX(), Background.getTileLength() * 10);
        gameContainer.addView(james.getGraphic());
        james.setAnimation(0);

        //James2
        James james2 = new James(getResources(), this, 8000, MainActivity.getScreenX() - 500, Background.getTileLength() * 10);
        gameContainer.addView(james2.getGraphic());

        james2.setAnimation(4000);


        //James3
        James james3 = new James(getResources(), this, 8000, MainActivity.getScreenX() - 500, Background.getTileLength() * 10);
        gameContainer.addView(james3.getGraphic());
        james3.setAnimation(8000);





        //Meowth
        Meowth meowth = new Meowth(getResources(), this, 6000, Background.getTileLength() * 11);
        gameContainer.addView(meowth.getGraphic());
        meowth.setAnimation(0);

        //Meowth2
        Meowth meowth2 = new Meowth(getResources(), this, 6000, Background.getTileLength() * 11);
        gameContainer.addView(meowth2.getGraphic());
        meowth2.setAnimation(3000);





        //Wobuffet
        Wobuffet wobuffet = new Wobuffet(getResources(), this,
                11000, Background.getTileLength() * 12);
        gameContainer.addView(wobuffet.getGraphic());
        wobuffet.setAnimation(0);

        //Wobuffet2
        Wobuffet wobuffet2 = new Wobuffet(getResources(), this,
                11000, Background.getTileLength() * 12);
        gameContainer.addView(wobuffet2.getGraphic());
        wobuffet2.setAnimation(1500);

        //Wobuffet3
        Wobuffet wobuffet3 = new Wobuffet(getResources(), this,
                11000, Background.getTileLength() * 12);
        gameContainer.addView(wobuffet3.getGraphic());
        wobuffet3.setAnimation(3000);

        //Grookey
        Grookey grookey = new Grookey(getResources(), this, 10000, Background.getTileLength() * 13);
        gameContainer.addView(grookey.getGraphic());
        grookey.setAnimation(0);

        //Grookey2
        Grookey grookey2 = new Grookey(getResources(), this, 10000, Background.getTileLength() * 13);
        gameContainer.addView(grookey2.getGraphic());
        grookey2.setAnimation(2000);

        //Grookey3
        Grookey grookey3 = new Grookey(getResources(), this, 10000, Background.getTileLength() * 13);
        gameContainer.addView(grookey3.getGraphic());
        grookey3.setAnimation(4000);
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
                boolean checkMoveUp = movement.moveUp();
                if (checkMoveUp) {
                    movement.setRow(movement.getRow() - 1);
                    if (movement.getRow() == 8) {
                        setStartConditions(true);
                    }
                    updateScore();
                    scoreDisplay.setText(Integer.toString(score));
                }
//                System.out.println("CHECKING COLLISIONS");
//                if (movement.checkCollision()) {
//                    setStartConditions();
//                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkMoveDown = movement.moveDown();
                if (checkMoveDown) {
                    movement.setRow(movement.getRow() + 1);
                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movement.moveLeft();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movement.moveRight();
            }
        });
    }
    public static int updateScore() {
        if (movement.getRow() < highestRow) {

            if (movement.getRow() == 10) {
                score += 4; // Jessi
            } else if (movement.getRow() == 11) {
                score += 3; // James
            } else if (movement.getRow() == 12) {
                score += 1; // Meowth
            } else if (movement.getRow() == 13) {
                score += 1; // Wobuffet
            } else if (movement.getRow() == 14) {
                score += 2; // Grookey
            }

            highestRow = movement.getRow();
        }
        System.out.println("SCORE: " + Integer.toString(score));
        return score;
    }


    public void removeLife() {
        System.out.println("REMOVING LIFE");
        lives--;
        livesDisplay.setText(Integer.toString(lives));
    }


    /**
     * This method returns the current score
     * @return current score
     */
    public static int getScore() {
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

    public static int getSafeScore() {
        return safeScore;
    }

    public static void setHighestRow(int highestRow) {
        GameActivity.highestRow = highestRow;
    }

    public int getLives() {
        return lives;
    }
}
