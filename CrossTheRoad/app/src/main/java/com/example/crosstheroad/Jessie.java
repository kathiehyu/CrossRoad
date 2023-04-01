package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.LinkedList;

public class Jessie extends RoadObstacle {


    public Jessie(Resources r, Context context, int duration, int y) {
        super(r, context, duration);
        setGraphic();
        getGraphic().setY(y);
    }

    @Override
    public void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                Background.getTileLength() * 3,
                Background.getTileLength(), Gravity.LEFT);

        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.jessie));
        super.setGraphic1(graphic);
    }

    //Jessie Animation??
    @Override
    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(),
                "translationX", (float) -MainActivity.getScreenX() + 500,
                (float) MainActivity.getScreenX() + 500);
        animator.setDuration(this.duration);
        animator.setStartDelay(x);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float charLeftBound = GameActivity.getMovement().getCharX();
                float charRightBound = GameActivity.getMovement().getCharX() + Background.getTileLength();
                float obstacleLeftBound = getGraphic().getX();
                float obstacleRighttBound = getGraphic().getX() + Background.getTileLength() * 3;
                if (GameActivity.getMovement().getRow() == 10 &&
                        ((charLeftBound > charLeftBound && charLeftBound < obstacleRighttBound)
                || (charRightBound > obstacleLeftBound && charRightBound < obstacleRighttBound))) {
                    GameActivity.setStartConditions();
                }
            }
        });
        animator.start();
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }
}
