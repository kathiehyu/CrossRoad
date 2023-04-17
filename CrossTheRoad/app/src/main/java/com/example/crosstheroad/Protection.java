package com.example.crosstheroad;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
public abstract class Protection extends Moveable {
    private float start;
    Protection(Resources r, Context context, int duration, int row, int length, float start) {
        super(r, context, duration, row, length);
        this.start = start;
    }

    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(),
                "translationX", start, start);
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
                if (GameActivity.getMovement().getRow() == row
                        && ((charLeftBound > obstacleLeftBound
                        && charLeftBound < obstacleRightBound)
                        || (charRightBound > obstacleLeftBound
                        && charRightBound < obstacleRightBound))) {
                    game.beProtected(true);
                }
            }
        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }


}
