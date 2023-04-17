package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


import java.util.LinkedList;



/**
 * This class will process the gameContainer's activity.
 */
public class GameActivity extends AppCompatActivity {
    private static GameView gameView;
    public static GameView getGameView() {return gameView;}
    private static int score = 0;

    private static int gameScore;

    private Togepi togepi;

    public static int getGameScore() {
        return gameScore;
    }
    private static int lives;

    private static int highestRow;

    private static TextView scoreDisplay;
    private static TextView livesDisplay;

    private static Movement movement;

    private static Context context;
    public Context getContext() {return context;}

    public static Movement getMovement() {
        return movement;
    }
    private static FrameLayout gameContainer;
    public static FrameLayout getGameContainer() {return gameContainer;}

    private LinkedList<Moveable> movables;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Successfully created GameActivity");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        context = GameActivity.this;
        lives = GameScreen.getLives();
        movables = new LinkedList<>();
        if (movables != null) {
            System.out.println("MOVABLES IS NOT NULL");
        }

        gameContainer = new FrameLayout(this);
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

        FrameLayout filler = new FrameLayout(this);
        FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(
                ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);
        p.width = 750;
        filler.setLayoutParams(p);

        ImageView heart = new ImageView(this);
        heart.setBackgroundResource(R.drawable.pixel_heart);
        LinearLayout.LayoutParams heartLayout =
                new LinearLayout.LayoutParams(ViewPager.LayoutParams.WRAP_CONTENT,
                        ViewPager.LayoutParams.WRAP_CONTENT);
        heartLayout.width = 125;
        heartLayout.height = 125;
        heart.setLayoutParams(heartLayout);



        scoreContainer.addView(scoreDisplay);
        scoreContainer.addView(filler);
        scoreContainer.addView(livesDisplay);
        scoreContainer.addView(heart);
        scoreContainer.setOrientation(LinearLayout.HORIZONTAL);

//        LinearLayout buttons = new LinearLayout(this);
//
//        Button up = new Button(this);
//        Button down = new Button(this);
//        Button left = new Button(this);
//        Button right = new Button(this);
//
//        configureButtons(up, down, left, right);

        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);

        gameContainer.setLayoutParams(frameParams);

//        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(
//                ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
//
//        buttons.setLayoutParams(gridParams);
//        buttons.addView(up);
//        buttons.addView(down);
//        buttons.addView(left);
//        buttons.addView(right);
//        buttons.setGravity(Gravity.BOTTOM);

        gameContainer.addView(gameView);
        gameContainer.addView(scoreContainer);
        gameContainer.addView(Character.getChar());
//        gameContainer.addView(buttons);
        context = this;
        ConfigureButtons configureButtons = new ConfigureButtons(context);
        configureButtons.configure();

        createRoadmoveables(gameContainer);

        createWatermoveables(gameContainer);

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
                if (lives <= 0) {
                    System.out.println("ATTEMPTING TO START GAME OVER");
                    Intent intent = new Intent(context, GameOverScreen.class);
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
        movement.setCharAnimator(null);

        gameScore = score;
        score = 0;
        if (scoreDisplay != null) {
            scoreDisplay.setText(Integer.toString(0));
        }
        movement.setRow(15);
        highestRow = 15;
        if (loseLife) {
            removeLife();
        }
    }

    public void beProtected(boolean yes) {
//        int x = Background.getTileLength()
//                * (MainActivity.getScreenX() / Background.getTileLength() / 2);
//        int y = Background.getTileLength()
//                * (MainActivity.getScreenY() / Background.getTileLength() - 8);
//        movement.setCharX(x);
//        movement.setCharY(y);
//        movement.setCharAnimator(null);
//        movement.setRow(9);
//        score = 11;
        slowDOwn(2000);
//        if (togepi != null) {
//            togepi.getGraphic().removeAllViews();
//            togepi.getAnimator().end();
//        }

    }

    private void slowDOwn(int delay) {
        if (movables != null) {
            System.out.println("MOVABLES IS NOT NULL");
            for (int i = 0; i < movables.size(); i++) {
                movables.get(i).setDuration(movables.get(i).getDuration() + delay);
                movables.get(i).setAnimation(movables.get(i).getDelay());
            }
        }
    }

    public void createTogepi(FrameLayout gameContainer){
        int x = 0;
        Random rand = new Random();
        List<Integer> numberX = Arrays.asList(1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000);
        List<Integer> numberY = Arrays.asList(10,11,12,13,14);
        int numX = numberX.get(rand.nextInt(numberX.size()));
        int numY = numberY.get(rand.nextInt(numberY.size()));
        float start = (float) -MainActivity.getScreenX() + numX;
        float end = (float) MainActivity.getScreenX() + 500;
        Togepi togepi = new Togepi(getResources(), this, 100000000, numY, 1, x, start, end);
        gameContainer.addView(togepi.getGraphic());
        togepi.setAnimation(0);
        this.togepi = togepi;
    }

    public void createJessies(FrameLayout gameContainer) {
        int x = -500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        //Jessie
        Jessie jessie = new Jessie(getResources(), this, 7000, 10, 3, x, start, end);
        gameContainer.addView(jessie.getGraphic());
        jessie.setAnimation(0);
        movables.add(jessie);

        //Jessie2
        Jessie jessie2 = new Jessie(getResources(), this, 7000, 10, 3, x, start, end);
        gameContainer.addView(jessie2.getGraphic());
        jessie2.setAnimation(3000);
        movables.add(jessie2);
    }

    public void createJames(FrameLayout gameContainer) {
        int x = MainActivity.getScreenX() + 500;
        float start = (float) MainActivity.getScreenX() + 500;
        float end = (float) -500;
        //James
        James james = new James(getResources(), this, 8000, 11, 2, x, start, end);
        gameContainer.addView(james.getGraphic());
        james.setAnimation(0);
        james.getAnimator().setFloatValues((float)  MainActivity.getScreenX() + 500, (float) -MainActivity.getScreenX() - 500);
        movables.add(james);

        //James2
        James james2 = new James(getResources(), this, 8000, 11, 2, x, start, end);
        gameContainer.addView(james2.getGraphic());
        james2.setAnimation(2200);
        james2.getAnimator().setFloatValues((float)  MainActivity.getScreenX() + 500, (float) -MainActivity.getScreenX() - 500);
        movables.add(james2);


        //James3
        James james3 = new James(getResources(), this, 8000, 11, 2, x, start, end);
        gameContainer.addView(james3.getGraphic());
        james3.setAnimation(4400);
        james3.getAnimator().setFloatValues((float)  MainActivity.getScreenX() + 500, (float) -MainActivity.getScreenX() - 500);
        movables.add(james3);
    }

    public void createMeowths(FrameLayout gameContainer) {
        int x = -500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        //Meowth
        Meowth meowth = new Meowth(getResources(), this, 6000, 12, 1, x, start, end);
        gameContainer.addView(meowth.getGraphic());
        meowth.setAnimation(0);
        movables.add(meowth);

        //Meowth2
        Meowth meowth2 = new Meowth(getResources(), this, 6000, 12, 1, x, start, end);
        gameContainer.addView(meowth2.getGraphic());
        meowth2.setAnimation(3000);
        movables.add(meowth2);
    }

    public void createWobuffets(FrameLayout gameContainer) {
        int x = -500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        //Wobuffet
        Wobuffet wobuffet = new Wobuffet(getResources(), this, 11000, 13, 1, x, start, end);
        gameContainer.addView(wobuffet.getGraphic());
        wobuffet.setAnimation(0);
        movables.add(wobuffet);

        //Wobuffet2
        Wobuffet wobuffet2 = new Wobuffet(getResources(), this,
                11000, 13, 1, x, start, end);
        gameContainer.addView(wobuffet2.getGraphic());
        wobuffet2.setAnimation(2200);
        movables.add(wobuffet2);

        //Wobuffet3
        Wobuffet wobuffet3 = new Wobuffet(getResources(), this,
                11000, 13, 1, x, start, end);
        gameContainer.addView(wobuffet3.getGraphic());
        wobuffet3.setAnimation(4400);
        movables.add(wobuffet3);
    }

    public void createGrookeys(FrameLayout gameContainer) {
        int x = MainActivity.getScreenX() + 500;
        float start = (float) MainActivity.getScreenX() + 500;
        float end = (float) -500;
        //Grookey
        Grookey grookey = new Grookey(getResources(), this, 10000, 14, 1, x, start, end);
        gameContainer.addView(grookey.getGraphic());
        grookey.setAnimation(0);
        movables.add(grookey);

        //Grookey2
        Grookey grookey2 = new Grookey(getResources(), this, 10000, 14, 1, x, start, end);
        gameContainer.addView(grookey2.getGraphic());
        grookey2.setAnimation(2200);
        movables.add(grookey2);

        //Grookey3
        Grookey grookey3 = new Grookey(getResources(), this, 10000, 14, 1, x, start, end);
        gameContainer.addView(grookey3.getGraphic());
        grookey3.setAnimation(4400);
        movables.add(grookey3);
    }

    public void createLagio(FrameLayout gameContainer) {
        int row = 2;
        int x = -500;
        float start = (float) MainActivity.getScreenX() + 500;
        float end = (float) -500;
        int duration = 40000;
        Lagio lagio = new Lagio(getResources(), this, duration,
                2, 1, x, start, end);
        lagio.setNum(0);
        gameContainer.addView(lagio.getGraphic());
        lagio.setAnimation(0);
        movables.add(lagio);

        //lagio2
        Lagio lagio2 = new Lagio(getResources(), this, duration,
                2, 1, x, start, end);
        lagio2.setNum(1);
        gameContainer.addView(lagio2.getGraphic());
        lagio2.setAnimation(2000);
         movables.add(lagio2);

        //lagio3
        Lagio lagio3 = new Lagio(getResources(), this, duration,
                2, 1, x, start, end);
        lagio3.setNum(2);
        gameContainer.addView(lagio3.getGraphic());
        lagio3.setAnimation(4000);
         movables.add(lagio3);

        //lagio4
        Lagio lagio4 = new Lagio(getResources(), this, duration,
                2, 1, x, start, end);
        lagio4.setNum(3);
        gameContainer.addView(lagio4.getGraphic());
        lagio4.setAnimation(6000);
        movables.add(lagio4);

    }

    public void createStars(FrameLayout gameContainer) {
        int row = 8;
        int x = -500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        int duration = 15000;
        Stars stars = new Stars(getResources(), this, duration,
                row, 4, x, start, end);
        stars.setNum(0);
        gameContainer.addView(stars.getGraphic());
        stars.setAnimation(0);
        movables.add(stars);

        //Star2
        Stars stars2 = new Stars(getResources(), this, duration,
                row, 4, x, start, end);
        stars2.setNum(1);
        gameContainer.addView(stars2.getGraphic());
        stars2.setAnimation(4000);
        movables.add(stars2);

        //star3
        Stars stars3 = new Stars(getResources(), this, duration,
                row, 4, x, start, end);
        stars3.setNum(2);
        gameContainer.addView(stars3.getGraphic());
        stars3.setAnimation(8000);
        movables.add(stars3);
    }

    public void createGyarados(FrameLayout gameContainer) {
        int row = 7;
        int x = MainActivity.getScreenX() + 500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        int duration = 11000;
        Gyarados gyarados = new Gyarados(getResources(), this, duration,
                row, 2, x, start, end);
        gyarados.setNum(0);
        gameContainer.addView(gyarados.getGraphic());
        gyarados.setAnimation(500);
        movables.add(gyarados);

        //Gyarados2
        Gyarados gyarados2 = new Gyarados(getResources(), this, duration,
                row, 2, x, start, end);
        gyarados2.setNum(1);

        gameContainer.addView(gyarados2.getGraphic());
        gyarados2.setAnimation(4500);
        movables.add(gyarados2);

        //Gyarados3
        Gyarados gyarados3 = new Gyarados(getResources(), this, duration,
                row, 2, x, start, end);
        gyarados3.setNum(2);
        gameContainer.addView(gyarados3.getGraphic());
        gyarados3.setAnimation(8500);
        movables.add(gyarados3);
    }

    public void createOctopus(FrameLayout gameContainer) {
        int row = 4;
        int x = -500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        int duration = 12000;
        Octopus octopus = new Octopus(getResources(), this, duration,
                row, 3, x, start, end);
        octopus.setNum(0);
        gameContainer.addView(octopus.getGraphic());
        octopus.setAnimation(0);
        movables.add(octopus);

        //octopus2
        Octopus octopus2 = new Octopus(getResources(), this, duration,
                row, 3, x, start, end);
        octopus2.setNum(1);
        gameContainer.addView(octopus2.getGraphic());
        octopus2.setAnimation(3100);
        movables.add(octopus2);

        //octopus3
        Octopus octopus3 = new Octopus(getResources(), this, duration,
                row, 3, x, start, end);
        octopus3.setNum(2);
        gameContainer.addView(octopus3.getGraphic());
        octopus3.setAnimation(6200);
        movables.add(octopus3);
    }

    public void createLapras(FrameLayout gameContainer) {
        int row = 6;
        int x = -500;
        float start = (float) MainActivity.getScreenX() + 500;
        float end = (float) -500;
        int duration = 18000;
        Lapras lapras = new Lapras(getResources(), this, duration,
                row, 3, x, start, end);
        lapras.setNum(0);
        gameContainer.addView(lapras.getGraphic());
        lapras.setAnimation(0);
         movables.add(lapras);

        //Lapras2
        Lapras lapras2 = new Lapras(getResources(), this, duration,
                row, 3, x, start, end);
        lapras2.setNum(1);
        gameContainer.addView(lapras2.getGraphic());
        lapras2.setAnimation(3100);
         movables.add(lapras2);

        //Lapras3
        Lapras lapras3 = new Lapras(getResources(), this, duration,
                row, 3, x, start, end);
        lapras3.setNum(2);
        gameContainer.addView(lapras3.getGraphic());
        lapras3.setAnimation(6200);
         movables.add(lapras3);

    }

    public void createFish(FrameLayout gameContainer) {
        int row = 5;
        int x = MainActivity.getScreenX() + 500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        int duration = 15000;
        Fish fish = new Fish(getResources(), this, duration,
                row, 4, x, start, end);
        fish.setNum(0);
        gameContainer.addView(fish.getGraphic());
        fish.setAnimation(1000);
        movables.add(fish);

        //Fish2
        Fish fish2 = new Fish(getResources(), this, duration,
                row, 4, x, start, end);
        fish2.setNum(1);
        gameContainer.addView(fish2.getGraphic());
        fish2.setAnimation(8000);
        movables.add(fish2);
    }

    public void createSeaHorse(FrameLayout gameContainer) {
        int row = 3;
        int x = MainActivity.getScreenX() + 500;
        float start = (float) -MainActivity.getScreenX() + 500;
        float end = (float) MainActivity.getScreenX() + 500;
        int duration = 10000;
        SeaHorse seaHorse = new SeaHorse(getResources(), this, duration,
                row, 4, x, start, end);
        seaHorse.setNum(0);
        gameContainer.addView(seaHorse.getGraphic());
        seaHorse.setAnimation(0);
        movables.add(seaHorse);

        //seahorse2
        SeaHorse seaHorse2 = new SeaHorse(getResources(), this, duration,
                row, 4, x, start, end);
        seaHorse2.setNum(1);
        gameContainer.addView(seaHorse2.getGraphic());
        seaHorse2.setAnimation(6000);
        movables.add(seaHorse2);
    }

    private void createRoadmoveables(FrameLayout gameContainer) {
        createJessies(gameContainer);
        createJames(gameContainer);
        createMeowths(gameContainer);
        createWobuffets(gameContainer);
        createGrookeys(gameContainer);
        createTogepi(gameContainer);
    }

    private void createWatermoveables(FrameLayout gameContainer) {
        createLagio(gameContainer);
        createStars(gameContainer);
        createGyarados(gameContainer);
        createOctopus(gameContainer);
        createLapras(gameContainer);
        createFish(gameContainer);
        createSeaHorse(gameContainer);
    }

//    private void configureButtons(Button up, Button down, Button left, Button right) {
//    up.setWidth(150);
//    up.setText("UP");
//
//    down.setWidth(150);
//    down.setText("DOWN");
//
//    left.setWidth(150);
//    left.setText("LEFT");
//
//    right.setWidth(150);
//    right.setText("RIGHT");
//
//    up.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            boolean checkMoveUp = movement.moveUp();
//            if (checkMoveUp) {
//                // remove animator
//                GameActivity.getMovement().setCharAnimator(null);
//                movement.setRow(movement.getRow() - 1);
//                updateScore();
//                if (movement.getRow() == 1) {
//                    openGameWinScreen();
//                }
//            }
//        }
//    });
//    down.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            boolean checkMoveDown = movement.moveDown();
//            if (checkMoveDown) {
//                // remove animator
//                GameActivity.getMovement().setCharAnimator(null);
//                movement.setRow(movement.getRow() + 1);
//            }
//        }
//    });
//    left.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            // remove animator
//            GameActivity.getMovement().setCharAnimator(null);
//            movement.moveLeft();
//        }
//    });
//    right.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            // remove animator
//            GameActivity.getMovement().setCharAnimator(null);
//            movement.moveRight();
//        }
//    });
//    }
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
        gameScore = score;
//         System.out.println("SCORE: " + (score));
        scoreDisplay.setText(Integer.toString(score));
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
        for (int i = 0; i < movables.size(); i++) {
            movables.get(i).getAnimator().pause();
        }
        gameView.pause();
        System.out.println("paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUMING");
        for (int i = 0; i < movables.size(); i++) {
            movables.get(i).getAnimator().resume();
        }
        gameView.resume();
        System.out.println("resumed");
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int num) {
        lives = num;
    }

    /**
     * ==================================================
     * THESE METHODS ARE MADE FOR UNIT TESTS PURPOSE ONLY
     * ==================================================
     * @param life1 life before hit.
     * @param life2 life after hit.
     * @return boolean.
     */

    public static boolean checkWaterTile(int life1, int life2) {
        if (life1 == life2) {
            return true;
        }
        return false;
    }

    public static boolean checkVehicleCollision(int life1, int life2) {
        if (life1 == life2) {
            return true;
        }
        return false;
    }

    public static boolean checkRespawned(int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkRespawnedScore(int score) {
        if (score == GameActivity.getScore()) {
            return true;
        }
        return false;
    }

    public static boolean checkKeepMaxScore(int score) {
        if (score  == GameActivity.getGameScore()) {
            return true;
        }
        return false;
    }

    public static boolean checkObstacleColliding(int charX, int obstacleX) {
        if (charX == obstacleX) {
            return true;
        }
        return false;
    }

    public static boolean checkWaterTileColliding(int water, int charY) {
        if (water == charY) {
            return true;
        }
        return false;
    }

    public static boolean checkZeroLife(int life) {
        if (life > 0) {
            return true;
        }
        return false;
    }

    public static void setScore(int newScore) {
        score = newScore;
    }
   public static void setScore(int newScore) {
        score = newScore;
    }
    public static int getLatestScore() {
        return score;
    }

    public void setMovement(Movement movement) {
    }

    public boolean checkCollisions() {
    return true;}

    public void setTile(int i, int i1, boolean isLog, int speed, int direction) {
    }
     public static String getWinMessage(int score) {
    return "you win";}

    public void update() {
    }

}
