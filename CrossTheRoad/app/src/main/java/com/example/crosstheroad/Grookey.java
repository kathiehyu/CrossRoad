package com.example.crosstheroad;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Grookey extends RoadMoveable {
    Grookey(Resources r, Context context, int duration, int row, int length, int x) {
        super(r, context, duration, row, length);
        setGraphic(r.getDrawable(R.drawable.grookey), x);
    }
}
