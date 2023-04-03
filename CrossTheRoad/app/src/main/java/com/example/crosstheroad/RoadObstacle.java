package com.example.crosstheroad;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;

public abstract class RoadObstacle extends Obstacle {
    // the higher the duration, the slower the obstacle
    protected int duration;
    private ImageView graphic;
    protected Resources r;
    protected Context context;
    public ImageView getGraphic() {
        return graphic;
    }
    RoadObstacle(Resources r, Context context, int duration) {
        this.duration = duration;
        this.r = r;
        this.context = context;
        setGraphic();
    }

    public void setGraphic1(ImageView graphic) {
        this.graphic = graphic;
    }

    abstract void setGraphic();

    public abstract void setAnimation(int x);
}
