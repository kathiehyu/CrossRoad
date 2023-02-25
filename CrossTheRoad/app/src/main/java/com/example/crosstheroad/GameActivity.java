package com.example.crosstheroad;

import static com.example.crosstheroad.Background.screenX;
import static com.example.crosstheroad.Background.screenY;
import static com.example.crosstheroad.Background.tileLength;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;

/**
 * This class will process the game's activity.
 */
public class GameActivity extends AppCompatActivity {
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("created instance state");
//        setContentView(R.layout.activity_game_activity);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        System.out.println("CREAETING BACKGROUND");
        Background bg = new Background(getResources(), this);

        gameView = new GameView(this, point.x, point.y);

        setContentView(gameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("PAUSING");
        gameView.pause();
        System.out.println("paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUMING");
        gameView.resume();
        System.out.println("resumed");
    }
}
