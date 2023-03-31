package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * This class will start the welcome screen (activity_main.xml) and display Start button
 * When you click Start, it'll call the configuration screen.
 */
public class MainActivity extends AppCompatActivity {
    private Button start;
    private static int screenX;
    private static int screenY;
    private static Resources resources;

    public static Resources getMAResources() {
        return resources;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resources = this.getResources();

        // create start button
        start = (Button) findViewById(R.id.Start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfiguration();
            }
        });

        // create exit button
        Button exit = (Button) findViewById(R.id.Exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });
        setDimensions();
    }

    private void setDimensions() {
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        screenX = display.widthPixels;
        screenY = display.heightPixels;
    }

    private void openConfiguration() {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }

    public static int getScreenX() {
        return screenX;
    }

    public static int getScreenY() {
        return screenY;
    }

    public static void setScreenX(int screenX) {
        MainActivity.screenX = screenX;
    }

    public static void setScreenY(int screenY) {
        MainActivity.screenY = screenY;
    }
}