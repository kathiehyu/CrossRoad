package com.example.crosstheroad;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;

public class Lapras extends WaterMoveable {
    private static Boolean[] list = new Boolean[]{false, false, false};
    private int num;
    private static int count = 0;
    private static boolean countTwice = false;
    public void setNum(int number) {
        num = number;
    }
    Lapras (Resources r, Context context, int duration, int row, int length, int x, float start, float end) {
        super(r, context, duration, row, length, start, end);
        setGraphic(r.getDrawable(R.drawable.lapras), x);

    }
    @Override
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
                count++;
                float charLeftBound = game.getMovement().getCharX();
                float charRightBound = game.getMovement().getCharX()
                        + Background.getTileLength();
                float obstacleLeftBound = getGraphic().getX();
                float obstacleRightBound = getGraphic().getX() + length;
                float midPoint = charLeftBound + Background.getTileLength() / 2;
                if (obstacleLeftBound > MainActivity.getScreenX() || obstacleRightBound < 0) {
                    return;
                }

                boolean collision = false;
                if (game.getMovement().getRow() == row && (midPoint < obstacleRightBound && midPoint > obstacleLeftBound)) {
                    collision = true;
                    list[num] = true;
                } else {
                    list[num] = false;
                }
                ObjectAnimator charAnimator = game.getMovement().getCharAnimator();
                if (collision) {

                    // start animation of character?
                    if (charAnimator == null) {
                        System.out.println("start character animation");
                        float speed = Math.abs((end - start) / duration);
                        float charStart = charLeftBound;
                        //- ((charLeftBound - obstacleLeftBound) % Background.getTileLength());
                        float distance = Math.abs(charStart - end);
                        charAnimator = ObjectAnimator.ofFloat(Character.getChar(), "translationX", charStart, end);
                        charAnimator.setDuration((long) (distance / speed));
                        charAnimator.setInterpolator(new LinearInterpolator());
                        game.getMovement().setCharAnimator(charAnimator);
                        charAnimator.start();
                    }

                }
                else if (game.getMovement().getRow() == row && count % 3 == 0) {
                    if (countTwice == false) {
                        countTwice = true;
                        return;
                    } else {
                        countTwice = false;
                    }
                    System.out.println("0: " + list[0] + " 1: " + list[1] + " 2: " + list[2] + " count: " + count);
                    if (list[0] == false && list[2] == false && list [1] == false) {
                        System.out.println("stars obstacleleft bound: " + obstacleLeftBound + "midpoint: " + midPoint + "right: " + obstacleRightBound);
                        System.out.println("screen: " + MainActivity.getScreenX());
                        if (charAnimator != null) {
                            charAnimator.pause();
                        } else {
                            System.out.println("char animator is null");
                        }
                        game.getMovement().setCharAnimator(charAnimator);
                        game.getMovement().setCharAnimator(null);
                        // player is on a water tile
                        game.setStartConditions(true);
                    }
                }
            }
        });
        animator.setStartDelay(x);
        animator.start();

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }

}
