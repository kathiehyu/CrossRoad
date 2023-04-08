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
    Moveable(Resources r, Context contecxt, int duration, int row, int length) {
        this.r = r;
        this.context = contecxt;
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
        System.out.println("SETTING GRAPHIC " + Boolean.toString(graphic != null));
        this.graphic = graphic;
        System.out.println("SET GRAPHIC " + Boolean.toString(graphic != null));
    }
    public ImageView getGraphic() {
        System.out.println("GETTING GRAPHIC " + Boolean.toString(graphic != null));
        return graphic;
    }
    public ObjectAnimator getAnimator() {
        return animator;
    }
}
