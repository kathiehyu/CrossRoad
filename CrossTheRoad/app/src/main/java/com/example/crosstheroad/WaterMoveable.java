package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.animation.LinearInterpolator;

public abstract class WaterMoveable extends Moveable {
    protected float start;
    protected float end;

    WaterMoveable(Resources r, Context context, int duration, int row, int length, float start, float end) {
        super(r, context, duration, row, length);
        this.start = start;
        this.end = end;
    }

    public void setAnimation(int x) {
        delay = x;
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(),
                "translationX", start, end);
        this.animator = animator;
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        GameActivity game = new GameActivity();
        animator.addUpdateListener(valueAnimator -> {
            float charLeftBound = game.getMovement().getCharX();
            float obstacleLeftBound = getGraphic().getX();
            float obstacleRightBound = getGraphic().getX() + length;
            float midPoint = charLeftBound + Background.getTileLength() / 2;

            if (game.getMovement().getRow() == row && (midPoint < obstacleRightBound
                    && midPoint > obstacleLeftBound)) {
                ObjectAnimator charAnimator = game.getMovement().getCharAnimator();
                System.out.println("FOUND COLLISION");

                // start animation of character?
                if (charAnimator == null) {
                    System.out.println("start character animation");
                    float speed = Math.abs((end - start) / duration);
                    float charStart = charLeftBound;
                    //- ((charLeftBound - obstacleLeftBound) % Background.getTileLength());
                    float distance = Math.abs(charStart - end);
                    charAnimator = ObjectAnimator.ofFloat(Character.getChar(),
                            "translationX", charStart, end);
                    charAnimator.setDuration((long) (distance / speed));
                    charAnimator.setInterpolator(new LinearInterpolator());
                    game.getMovement().setCharAnimator(charAnimator);
                    charAnimator.start();
                }

            }
        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }
}
