package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.sql.SQLOutput;

public abstract class WaterMoveable extends Moveable {
    private float start;
    private float end;

    WaterMoveable(Resources r, Context context, int duration, int row, int length, float start, float end) {
        super(r, context, duration, row, length);
        this.start = start;
        this.end = end;
    }


    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(),
                "translationX", start, end);
        this.animator = animator;
        System.out.println("THIS DURATION: " + Integer.toString(duration));
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        GameActivity game = new GameActivity();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float charLeftBound = GameActivity.getMovement().getCharX();
                float charRightBound = GameActivity.getMovement().getCharX()
                        + Background.getTileLength();
                float obstacleLeftBound = getGraphic().getX();
                float obstacleRightBound = getGraphic().getX() + length;
                float midPoint = charLeftBound + Background.getTileLength() / 2;
                if (GameActivity.getMovement().getRow() == row
                        && ((((charLeftBound > obstacleLeftBound
                        && charLeftBound < obstacleRightBound) && midPoint < obstacleRightBound))
                        || ((charRightBound > obstacleLeftBound
                        && charRightBound < obstacleRightBound) && midPoint > obstacleLeftBound))) {
                    ObjectAnimator charAnimator = GameActivity.getMovement().getCharAnimator();
                    System.out.println("FOUND COLLISION");
                    System.out.println("character animator null? " + Boolean.toString(charAnimator == null));
                    // start animation of character?
                    if (charAnimator == null) {
//                        charAnimator = new ObjectAnimator.ofFloat(GameActivity.getMovement().getGraphic(), "translationX", start, end);
                        GameActivity.getMovement().setCharAnimator(animator.clone());
//                        GameActivity.getMovement().getCharAnimator().set
                        GameActivity.getMovement().getCharAnimator().start();
                    }
                } else if (GameActivity.getMovement().getRow() == row) {
                    // player is on a water tile
                    // remove animator
                    GameActivity.getMovement().setCharAnimator(null);
                    game.setStartConditions(true);
                }
            }
        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }
}
