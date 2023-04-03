package com.example.crosstheroad;

import android.widget.ImageView;

public abstract class WaterObstacle extends Obstacle implements FloatableInterface {
    protected int duration;
    private ImageView graphic;
    @Override
    public void setFloat() {
        return;
    }
}
