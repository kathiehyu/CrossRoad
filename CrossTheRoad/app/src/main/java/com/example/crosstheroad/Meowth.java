package com.example.crosstheroad;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class Meowth extends RoadObstacle {
    Meowth(Resources r, Context context, int duration, int y) {
        super(r, context, duration);
        setGraphic();
        getGraphic().setY(y);
        getGraphic().setX(-500);
    }

    @Override
    void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new
                FrameLayout.LayoutParams(Background.getTileLength(),
                Background.getTileLength(), Gravity.LEFT);
        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.meowth));
        super.setGraphic1(graphic);
    }

    @Override
    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(),
                "translationX", (float) -MainActivity.getScreenX() + 500,
                (float) MainActivity.getScreenX() + 500);
        animator.setDuration(this.duration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                GameActivity game = new GameActivity();
                float charLeftBound = GameActivity.getMovement().getCharX();
                float charRightBound = GameActivity.getMovement().getCharX()
                        + Background.getTileLength();
                float obstacleLeftBound = getGraphic().getX();
                float obstacleRightBound = getGraphic().getX() + Background.getTileLength();
                if (GameActivity.getMovement().getRow() == 12
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
}

