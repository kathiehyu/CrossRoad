package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.sql.SQLOutput;

public abstract class Moveable {
    protected int duration;
    protected RelativeLayout graphic;
    protected ObjectAnimator animator;
    protected int row;
    protected int length;
    protected Resources r;
    protected Context context;
    Moveable(Resources r, Context context, int duration, int row, int length) {
        this.r = r;
        this.context = context;
        this.duration = duration;
        this.row = row;
        this.length = Background.getTileLength() * length;;
    }
    public void setGraphic(Drawable drawable, int x) {
        ImageView graphic = new ImageView(context);
        RelativeLayout container = new RelativeLayout(context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                length, Background.getTileLength());

        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(drawable);
        container.addView(graphic);
        container.setY(Background.getTileLength() * (row - 1));
        container.setX(x);
        this.graphic = container;
    }
    public RelativeLayout getGraphic() {
        return graphic;
    }
    public ObjectAnimator getAnimator() {
        return animator;
    }
}
