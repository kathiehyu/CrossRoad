package com.example.crosstheroad;
import android.content.Context;
import android.content.res.Resources;

public class Grookey extends RoadMoveable {
    Grookey(Resources r, Context context, int duration, int row, int length, int x, float start, float end) {
        super(r, context, duration, row, length, start, end);
        setGraphic(r.getDrawable(R.drawable.grookey), x);
    }
}
