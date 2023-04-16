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
//                            ImageView temp = new ImageView(context);
//                            temp.setImageDrawable(r.getDrawable(R.drawable.character_1));
//                            getGraphic().addView(temp);
                        } else if (charLeftBound < obstacleLeftBound && Character.getChar().getParent() instanceof FrameLayout) {
                            System.out.println("COLLISION ON LEFT");
                            FrameLayout parent = (FrameLayout) Character.getChar().getParent();
                            parent.removeView(Character.getChar());
                            getGraphic().addView(Character.getChar());
//                            ImageView temp = new ImageView(context);
//                            temp.setImageDrawable(r.getDrawable(R.drawable.character_1));
//                            getGraphic().addView(temp);
                        } else {
                            if (Character.getChar().getParent() instanceof FrameLayout) {
                                System.out.println("MIDDLE COLLISION");
                                FrameLayout parent = (FrameLayout) Character.getChar().getParent();
                                parent.removeView(Character.getChar());
                                getGraphic().addView(Character.getChar());
//                                ImageView temp = new ImageView(context);
//                                temp.setImageDrawable(r.getDrawable(R.drawable.character_1));
//                                getGraphic().addView(temp);
                            }
                        }

                    }
                    else if (GameActivity.getMovement().getRow() == row
                            && (midPoint > obstacleRightBound || midPoint < obstacleLeftBound)) {
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
