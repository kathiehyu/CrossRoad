package com.example.crosstheroad;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
public class Wobuffet extends RoadObstacle {
    Wobuffet(Resources r, Context context, int duration, int y) {
        super(r, context, duration);
        setGraphic();
//        graphic.setX(-Background.getTileLength());
        graphic.setY(y);
    }

    @Override
    void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(Background.getTileLength(),
                Background.getTileLength(), Gravity.LEFT);
        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.wobbuffet));
        super.graphic = graphic;
    }

    @Override
    public void setAnimation(int x) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.graphic, "translationX", (float) -MainActivity.getScreenX(),(float) MainActivity.getScreenX());
        animator.setDuration(this.duration);
        animator.setStartDelay(x);
        animator.start();
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
    }
}