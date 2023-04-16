package com.example.crosstheroad;

import android.content.Context;
import android.content.res.Resources;

public class Jessie extends RoadMoveable {

    public Jessie(Resources r, Context context, int duration, int row, int length, int x, float start, float end) {
        super(r, context, duration, row, length, start, end);
        setGraphic(r.getDrawable(R.drawable.jessie), x);
    }
}
