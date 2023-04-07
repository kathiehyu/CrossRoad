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

public class James extends RoadObstacle {

    private int startX;
    James(Resources r, Context context, int duration, int row, int length) {
        super(r, context, duration, row, length);
        setGraphic();
        getGraphic().setY(Background.getTileLength() * (row - 1));
        getGraphic().setX(MainActivity.getScreenX() + 500);
    }

    @Override
    void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                Background.getTileLength() * 2,
                                                Background.getTileLength(), Gravity.RIGHT);
        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.james));
        super.setGraphic1(graphic);
    }
}
