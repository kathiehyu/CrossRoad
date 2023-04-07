package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class Jessie extends RoadObstacle {

    public Jessie(Resources r, Context context, int duration, int row, int length) {
        super(r, context, duration, row, length);
        setGraphic();
        getGraphic().setY(Background.getTileLength() * (row - 1));
        getGraphic().setX(-500);
    }

    @Override
    public void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                Background.getTileLength() * 3,
                Background.getTileLength(), Gravity.LEFT);

        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.jessie));
        super.graphic = graphic;
    }
}
