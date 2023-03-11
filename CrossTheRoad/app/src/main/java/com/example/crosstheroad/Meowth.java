package com.example.crosstheroad;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
public class Meowth extends RoadObstacle {
    Meowth (Resources r, Context context, int duration, int y) {
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
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.meowth));
        super.graphic = graphic;
    }

    @Override
    public void setAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.graphic, "translationX", 1300f);
        animator.setDuration(this.duration);
        animator.start();
    }
}

