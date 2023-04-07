package com.example.crosstheroad;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class Meowth extends RoadObstacle {
    Meowth(Resources r, Context context, int duration, int row, int length) {
        super(r, context, duration, row, length);
        setGraphic();
        getGraphic().setY(Background.getTileLength() * (row - 1));
        getGraphic().setX(-500);
    }

    @Override
    void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new
                FrameLayout.LayoutParams(Background.getTileLength(),
                Background.getTileLength(), Gravity.LEFT);
        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.meowth));
        super.setGraphic1(graphic);
    }
}

