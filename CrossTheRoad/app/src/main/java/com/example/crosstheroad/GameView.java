package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;

public class GameView extends AppCompatActivity {
    private Surface surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        surface = new Surface(this, point.x, point.y);
        setContentView(surface);


    }

    @Override
    protected void onPause() {
        super.onPause();
        surface.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        surface.resume();
    }
}