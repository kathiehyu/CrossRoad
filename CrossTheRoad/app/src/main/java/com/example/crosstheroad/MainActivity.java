package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    static int screenX, screenY;
    static Bitmap riverBmap;
    static Bitmap grassBmap;
    static Bitmap sandBmap;
    static Bitmap roadBmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        riverBmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.water_tile);
        grassBmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass_tile);
        sandBmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.sand_tile);
        roadBmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.road1);
        assert (riverBmap != null);

        start = (Button) findViewById(R.id.Start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfiguration();
            }
        });


        Button exit = (Button) findViewById(R.id.Exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });

        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        screenX = display.widthPixels;
        screenY = display.heightPixels;
    }

    public void openConfiguration() {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }
}