package com.example.crosstheroad;

import android.content.Context;
import android.content.res.Resources;

public class Jessie extends RoadMoveable {

    public Jessie(Resources r, Context context, int duration, int row, int length, float start) {
        super(r, context, duration, row, length, start);
        setGraphic(r.getDrawable(R.drawable.jessie), -500);
    }
}
