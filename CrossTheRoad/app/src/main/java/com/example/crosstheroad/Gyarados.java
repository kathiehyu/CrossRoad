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

public class Gyarados extends WaterMoveable {

    public Gyarados(Resources r, Context context, int duration, int row, int length, int x) {
        super(r, context, duration, row, length);
        setGraphic(r.getDrawable(R.drawable.gyarados), x);

    }
}
