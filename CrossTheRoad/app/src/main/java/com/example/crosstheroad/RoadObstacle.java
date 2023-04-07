package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public abstract class RoadObstacle extends Obstacle {
    // the higher the duration, the slower the obstacle
    protected int duration;
    protected Resources r;
    protected Context context;
    protected ObjectAnimator animator;
    protected ImageView graphic;
    protected int row;
    protected int length;
    public ImageView getGraphic() {
        return graphic;
    }
    RoadObstacle(Resources r, Context context, int duration, int row, int length) {
        this.duration = duration;
        this.r = r;
        this.row = row;
        this.context = context;
        this.length = Background.getTileLength() * length;
        setGraphic();
    }

    abstract void setGraphic();

    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(),
                "translationX", (float) -MainActivity.getScreenX() + 500,
                (float) MainActivity.getScreenX() + 500);
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
                    game.setStartConditions(true);
                }
            }
        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }

    public ObjectAnimator getAnimator() {
        return animator;
    }
}
