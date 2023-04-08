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
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        GameActivity game = new GameActivity();
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
//                float charLeftBound = GameActivity.getMovement().getCharX();
//                float charRightBound = GameActivity.getMovement().getCharX()
//                        + Background.getTileLength();
//                float obstacleLeftBound = getGraphic().getX();
//                float obstacleRightBound = getGraphic().getX() + length;
//                float midPoint = charLeftBound + Background.getTileLength() / 2;
////                System.out.println("LEFT COLLISION? " + Boolean.toString(((charLeftBound > obstacleLeftBound
////                        && charLeftBound < obstacleRightBound) && midPoint < obstacleRightBound)));
////                System.out.println("MIDPOINT? " + Boolean.toString( midPoint < obstacleRightBound));
////                System.out.println("RIGHT COLLISION? " + Boolean.toString(((charRightBound > obstacleLeftBound
////                        && charRightBound < obstacleRightBound) && midPoint > obstacleLeftBound)));
////                System.out.println("MIDPOINT? " + Boolean.toString(  midPoint > obstacleLeftBound));
//                if (GameActivity.getMovement().getRow() == row) System.out.println("COLLISION? " + Boolean.toString((midPoint < obstacleRightBound && midPoint > obstacleLeftBound)));
//                if (GameActivity.getMovement().getRow() == row && (midPoint < obstacleRightBound && midPoint > obstacleLeftBound)) {
//                    ObjectAnimator charAnimator = GameActivity.getMovement().getCharAnimator();
//                    System.out.println("FOUND COLLISION");
//                    System.out.println("character animator null? " + Boolean.toString(charAnimator == null));
//                    if (charRightBound > obstacleRightBound) {
//                        System.out.println("COLLISION ON RIGHT");
//                        GameActivity.getMovement().setCharX(Math.round(obstacleLeftBound));
//                    } else if (charLeftBound < obstacleLeftBound) {
//                        System.out.println("COLLISION ON LEFT");
//                        GameActivity.getMovement().setCharX(Math.round(obstacleRightBound - Background.getTileLength()));
//                    } else {
//                        System.out.println("MIDDLE COLLISION");
//                        GameActivity.getMovement().setCharX(Math.round(charLeftBound - ((charLeftBound - obstacleLeftBound) % Background.getTileLength())));
//                    }
//
//                    // start animation of character?
////                    if (charAnimator == null) {
////                        float speed = Math.abs((end - start) / duration);
////                        float charStart = charLeftBound - ((charLeftBound - obstacleLeftBound) % Background.getTileLength());
////                        float distance = Math.abs(charStart - end);
////                        charAnimator = ObjectAnimator.ofFloat(Character.getChar(), "translationX", charStart, end);
////                        charAnimator.setDuration((long) (distance / speed));
////                        charAnimator.setInterpolator(new LinearInterpolator());
////                        charAnimator.start();
////                    }
//
//                }  else if (GameActivity.getMovement().getRow() == row) {
//                    System.out.println("ON WATER!! AHHH!!");
//                    // player is on a water tile
//                    game.setStartConditions(true);
//                }
//            }
//        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }
}
