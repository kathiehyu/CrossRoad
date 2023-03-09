package com.example.crosstheroad;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
public class Grookey extends RoadObstacle {
    Grookey (Resources r, Context context, int duration, int y) {
        super(r, context, duration);
        setGraphic();
        graphic.setX(-Background.getTileLength());
        graphic.setY(y);
    }

    @Override
    void setGraphic() {
        ImageView graphic = new ImageView(super.context);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(Background.getTileLength(),
                Background.getTileLength(), Gravity.RIGHT);
        graphic.setLayoutParams(frameParams);
        graphic.setImageDrawable(super.r.getDrawable(R.drawable.grookey));
        super.graphic = graphic;
    }
}
