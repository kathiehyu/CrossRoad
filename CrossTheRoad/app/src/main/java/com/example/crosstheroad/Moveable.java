package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.sql.SQLOutput;

public abstract class Moveable {
    protected int duration;
    protected ImageView graphic;
    protected ObjectAnimator animator;
    protected int row;
    protected int length;
    protected Resources r;
    protected Context context;
    protected GameActivity gameActivityObj = GameActivity.getGameActivityObj();
    Moveable(Resources r, Context context, int duration, int row, int length) {
        this.r = r;
        this.context = context;
        this.duration = duration;
        this.row = row;
        this.length = Background.getTileLength() * length;;
    }
    public void setGraphic(Drawable drawable, int x) {
        ImageView graphic = new ImageView(context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                length, Background.getTileLength(), Gravity.LEFT);

        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(drawable);
        graphic.setY(Background.getTileLength() * (row - 1));
        graphic.setX(x);
        this.graphic = graphic;
    }
    public ImageView getGraphic() {
        return graphic;
    }
    public ObjectAnimator getAnimator() {
        return animator;
    }
}
