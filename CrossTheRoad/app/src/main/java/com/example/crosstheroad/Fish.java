package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;

public class Fish extends WaterMoveable {
    private static Boolean[] list = new Boolean[]{false, false, false};
    private int num;
    private static int count = 0;
    public void setNum(int number) {
        num = number;
    }

    public Fish(Resources r, Context context, int duration, int row, int length, int x, float start, float end) {
        super(r, context, duration, row, length, start, end);
        setGraphic(r.getDrawable(R.drawable.fish), x);
    }
    @Override
    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.getGraphic(),
                "translationX", start, end);
        this.animator = animator;
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float charLeftBound = gameActivityObj.getMovement().getCharX();
                float charRightBound = gameActivityObj.getMovement().getCharX()
                        + Background.getTileLength();
                float obstacleLeftBound = getGraphic().getX();
                float obstacleRightBound = getGraphic().getX() + length;
                float midPoint = charLeftBound + Background.getTileLength() / 2;
                boolean collision = false;
                if (gameActivityObj.getMovement().getRow() == row && (midPoint < obstacleRightBound && midPoint > obstacleLeftBound)) {
                    collision = true;
                    list[num] = true;
                } else {
                    list[num] = false;
                }
                if (collision) {
                    ObjectAnimator charAnimator = gameActivityObj.getMovement().getCharAnimator();
                    // start animation of character?
                    if (charAnimator == null) {
                        //GameActivity.getMovement().setCharAnimator(start, end, duration, charLeftBound, obstacleLeftBound);
                        System.out.println("start character animation");
                        float speed = Math.abs((end - start) / duration);
                        float charStart = charLeftBound;
                        //- ((charLeftBound - obstacleLeftBound) % Background.getTileLength());
                        float distance = Math.abs(charStart - end);
                        charAnimator = ObjectAnimator.ofFloat(Character.getChar(), "translationX", charStart, end);
                        charAnimator.setDuration((long) (distance / speed));
                        charAnimator.setInterpolator(new LinearInterpolator());
                        gameActivityObj.getMovement().setCharAnimator(charAnimator);
                        charAnimator.start();
                    }

                }
//                else if (gameActivityObj.getMovement().getRow() == row) {
//                    System.out.println("0: " + list[0] + " 1: " + list[1] + " 2: " + list[2] + " count: " + count++);
//                    if (list[0] == false && list[2] == false && list [1] == false) {
//                        gameActivityObj.getMovement().setCharAnimator(null);
//                        // player is on a water tile
//                        gameActivityObj.setStartConditions(true);
//                    }
//                }
            }
        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }


}
