package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Jessie extends RoadObstacle {
    Jessie(Resources r, Context context, int duration, int y) {
        super(r, context, duration);
        setGraphic();
//        graphic.setX(-Background.getTileLength());
        graphic.setY(y);
    }

    @Override
    protected void setGraphic() {
        ImageView graphic = new ImageView(super.context);
//        graphic.setMaxWidth(Background.getTileLength() + 100);
//        graphic.setMaxHeight(Background.getTileLength());
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(Background.getTileLength() * 3, Background.getTileLength(), Gravity.LEFT);

        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.jessie));
//        graphic.setScaleX((Background.getTileLength() + 100) / super.r.getDrawable(R.drawable.waterball).getMinimumWidth());
//        this * scale = tilelength
//                scale = tilelength / this
//        graphic.setScaleY(Background.getTileLength() / super.r.getDrawable(R.drawable.waterball).getMinimumHeight());
//        graphic.setScaleY(0.5f);
//        graphic.setScaleX(0.5f);
        super.graphic = graphic;
        System.out.println("ADDED WATERBALL GRAPHIC");
    }

    //Jessie Animation??
    @Override
    public void setAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.graphic, "translationX", (float) MainActivity.getScreenX());
        animator.setDuration(this.duration);
        animator.start();
        System.out.println("ANIMATOR STARTED");
    }
}
