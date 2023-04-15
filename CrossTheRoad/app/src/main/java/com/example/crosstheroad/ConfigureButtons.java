package com.example.crosstheroad;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

public class ConfigureButtons extends GameActivity {
    private Button up;
    private Button down;
    private Button left;
    private Button right;
    private Movement movement = GameActivity.getMovement();
    private FrameLayout gameContainer = GameActivity.getGameContainer();
    private Context gameActivityContext;
    private GameActivity gameActivityObj = GameActivity.getGameActivityObj();

    public ConfigureButtons(Context context) {
        gameActivityContext = context;
        up = new Button(gameActivityContext);
        down = new Button(gameActivityContext);
        left = new Button(gameActivityContext);
        right = new Button(gameActivityContext);

        up.setWidth(150);
        up.setText("UP");

        down.setWidth(150);
        down.setText("DOWN");

        left.setWidth(150);
        left.setText("LEFT");

        right.setWidth(150);
        right.setText("RIGHT");
        LinearLayout buttons = new LinearLayout(gameActivityContext);
        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(
                ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);

        buttons.setLayoutParams(gridParams);
        buttons.addView(up);
        buttons.addView(down);
        buttons.addView(left);
        buttons.addView(right);
        buttons.setGravity(Gravity.BOTTOM);

        gameContainer.addView(buttons);
    }

    public void configure() {
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkMoveUp = movement.moveUp();
                if (checkMoveUp) {
                    // remove animator
                    gameActivityObj.getMovement().setCharAnimator(null);
                    movement.setRow(movement.getRow() - 1);
                    updateScore();
                    if (movement.getRow() == 1) {
                        openGameWinScreen();
                    }
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkMoveDown = movement.moveDown();
                if (checkMoveDown) {
                    // remove animator
                    gameActivityObj.getMovement().setCharAnimator(null);

                    movement.setRow(movement.getRow() + 1);
                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // remove animator
                gameActivityObj.getMovement().setCharAnimator(null);
                movement.moveLeft();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // remove animator
                gameActivityObj.getMovement().setCharAnimator(null);
                movement.moveRight();
            }
        });
    }
    public void openGameWinScreen(){
        Intent intent = new Intent(gameActivityContext, GameWinScreen.class);
        gameActivityContext.startActivity(intent);
    }
}
