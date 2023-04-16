package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.text.method.MovementMethod;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
//                if (game.getMovement().getPokemonOn() == WaterMoveable.this) {
//                    game.getMovement().s
//                }
                float charLeftBound = GameActivity.getMovement().getCharX();
                float charRightBound = GameActivity.getMovement().getCharX()
                        + Background.getTileLength();
                float obstacleLeftBound = getGraphic().getX();
                float obstacleRightBound = getGraphic().getX() + length;
                float midPoint = charLeftBound + Background.getTileLength() / 2;
//                Movement charMovement = game.getMovement();
//                if (game.getMovement().getPokemonOn() == null) {
                    if (GameActivity.getMovement().getRow() == row && (midPoint < obstacleRightBound && midPoint > obstacleLeftBound)) {
//                        game.getMovement().setPokemonOn(WaterMoveable.this);
                        System.out.println("OBSTACLE DEPTH: " + getGraphic().getY());
                        System.out.println("CHARACTER DEPTH: " + Character.getChar().getY());
                        if (charRightBound > obstacleRightBound && Character.getChar().getParent() instanceof FrameLayout) {
                            System.out.println("COLLISION ON RIGHT");
                            FrameLayout parent = (FrameLayout) Character.getChar().getParent();
                            parent.removeView(Character.getChar());
                            getGraphic().addView(Character.getChar());
                            Character.getChar().setY(getGraphic().getY());
//                            ImageView temp = new ImageView(context);
//                            temp.setImageDrawable(r.getDrawable(R.drawable.character_1));
//                            getGraphic().addView(temp);
                        } else if (charLeftBound < obstacleLeftBound && Character.getChar().getParent() instanceof FrameLayout) {
                            System.out.println("COLLISION ON LEFT");
                            FrameLayout parent = (FrameLayout) Character.getChar().getParent();
                            parent.removeView(Character.getChar());
                            getGraphic().addView(Character.getChar());
                            Character.getChar().setY(getGraphic().getY());
//                            ImageView temp = new ImageView(context);
//                            temp.setImageDrawable(r.getDrawable(R.drawable.character_1));
//                            getGraphic().addView(temp);
                        } else {
                            if (Character.getChar().getParent() instanceof FrameLayout) {
                                System.out.println("MIDDLE COLLISION");
                                FrameLayout parent = (FrameLayout) Character.getChar().getParent();
                                parent.removeView(Character.getChar());
                                getGraphic().addView(Character.getChar());
                                Character.getChar().setY(getGraphic().getY());
//                                ImageView temp = new ImageView(context);
//                                temp.setImageDrawable(r.getDrawable(R.drawable.character_1));
//                                getGraphic().addView(temp);
                            }
                        }
//                        game.getMovement().setCharX(Math.round(obstacleLeftBound));
//                        game.getMovement().setCharY(Math.round(getGraphic().getY()));

//                        System.out.println("BEFORE: " + charMovement.getRow());
//                        System.out.println("SETTING GRAPHIC TO: " + Background.getTileLength() * (row - 1));
//                        charMovement.setCharY(Background.getTileLength() * (row - 1));
//                        charMovement.setRow(row);
//                        System.out.println("AFTER: " + charMovement.getRow());
                    }


                    // animator implementation
/*                System.out.println("MIDPOINT? " + Boolean.toString(  midPoint > obstacleLeftBound));
//                if (GameActivity.getMovement().getRow() == row) {
//                    System.out.println("COLLISION? " +
//                            Boolean.toString((midPoint < obstacleRightBound && midPoint > obstacleLeftBound)));
//                }
//                if (GameActivity.getMovement().getRow() == row && (midPoint < obstacleRightBound && midPoint > obstacleLeftBound)) {
//                    ObjectAnimator charAnimator = GameActivity.getMovement().getCharAnimator();
//                    System.out.println("FOUND COLLISION");
//                    System.out.println("character animator null? " + Boolean.toString(charAnimator == null));
//
//
//
//
//                    // animator implementation
//                    if (charRightBound > obstacleRightBound) {
//                        System.out.println("COLLISION ON RIGHT");
////                        GameActivity.getMovement().setCharX(Math.round(obstacleLeftBound));
//                        GameActivity.getMovement().setCharX(Math.round(obstacleRightBound - Background.getTileLength()));
//                    } else if (charLeftBound < obstacleLeftBound) {
//                        System.out.println("COLLISION ON LEFT");
//                        GameActivity.getMovement().setCharX(Math.round(obstacleRightBound - Background.getTileLength()));
////                        GameActivity.getMovement().setCharX(Math.round(obstacleLeftBound));
//                    } else {
//                        System.out.println("MIDDLE COLLISION");
////                        GameActivity.getMovement().setCharX(Math.round(obstacleLeftBound));
//                        GameActivity.getMovement().setCharX(Math.round(obstacleRightBound - Background.getTileLength()));
////                        GameActivity.getMovement().setCharX(Math.round(charLeftBound - ((charLeftBound - obstacleLeftBound) % Background.getTileLength())));
//                    }
////                    GameActivity.getMovement().setCharX(Math.round(obstacleRightBound - Background.getTileLength()));
//
//                    // start animation of character?
//                    if (charAnimator == null) {
//                        float speed = Math.abs((end - start) / duration);
//                        float charStart = charLeftBound - ((charLeftBound - obstacleLeftBound) % Background.getTileLength());
//                        float distance = Math.abs(charStart - end);
//                        charAnimator = ObjectAnimator.ofFloat(Character.getChar(), "translationX", charStart, end);
//                        charAnimator.setDuration((long) (distance / speed));
//                        charAnimator.setInterpolator(new LinearInterpolator());
//                        System.out.println("starting animation");
////                        charAnimator.start();
//                    }
//
//                }  else if (GameActivity.getMovement().getRow() == row && (midPoint < obstacleLeftBound && midPoint > obstacleRightBound)) {
//                    System.out.println("ON WATER!! AHHH!!");
//                    // player is on a water tile
//                    game.setStartConditions(true);
//                } */
                }
//            }
        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }
}
