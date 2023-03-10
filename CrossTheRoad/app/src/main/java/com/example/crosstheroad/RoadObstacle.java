package com.example.crosstheroad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public abstract class RoadObstacle {
    // the higher the duration, the slower the obstacle
    protected int duration;
    protected ImageView graphic;
    protected Resources r;
    protected Context context;
    RoadObstacle(Resources r, Context context, int duration) {
        this.duration = duration;
        this.r = r;
        this.context = context;
        setGraphic();
    }

    abstract void setGraphic();

    abstract void setAnimation();
}
