package com.example.crosstheroad;
import android.content.Context;
import android.content.res.Resources;

public class Wobuffet extends RoadMoveable {
    Wobuffet(Resources r, Context context, int duration, int row, int length, float start) {
        super(r, context, duration, row, length, start);
        setGraphic(r.getDrawable(R.drawable.wobbuffet), -500);
    }
}
