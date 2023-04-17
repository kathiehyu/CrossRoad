package com.example.crosstheroad;
import android.content.Context;
import android.content.res.Resources;

public class Togepi extends Protection {

    Togepi(Resources r, Context context, int duration, int row, int length, float start) {
        super(r, context, duration, row, length, start);
        setGraphic(r.getDrawable(R.drawable.togepi2), (int) start);
    }
}

