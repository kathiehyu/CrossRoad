package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class James extends RoadObstacle {

    private int startX;
    James(Resources r, Context context, int duration, int startX, int y) {
        super(r, context, duration);
        setGraphic();
        getGraphic().setY(y);
        getGraphic().setX(MainActivity.getScreenX() + 500);
    }

    @Override
    void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                Background.getTileLength() * 2,
                                                Background.getTileLength(), Gravity.RIGHT);
        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.james));
        super.setGraphic1(graphic);
    }

    //James animation
    @Override
    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(), "translationX",
                (float)  MainActivity.getScreenX() - 500,
                (float) -MainActivity.getScreenX() - 500);
        animator.setDuration(this.duration);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                GameActivity game = new GameActivity();
                float charLeftBound = GameActivity.getMovement().getCharX();
                float charRightBound = GameActivity.getMovement().getCharX()
                        + Background.getTileLength();
                float obstacleLeftBound = getGraphic().getX();
                float obstacleRightBound = getGraphic().getX() + Background.getTileLength() * 2;
                if (GameActivity.getMovement().getRow() == 11
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
