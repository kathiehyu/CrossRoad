package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;

/**
 * This class will process the game's activity.
 */
public class GameActivity extends AppCompatActivity {
    protected static Bitmap bmap;

    // number of tiles across screen (determines size of tiles)
    protected static int widthInTiles = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_activity);

        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int tileLength = display.widthPixels / widthInTiles;
//        System.out.println(display.heightPixels); //1977
//        System.out.println(display.widthPixels); //1080


        // MAP USING ARRAY OF IMAGEVIEWS: takes too long to load
//        LinearLayout grid = findViewById(R.id.map);
//        int id = 1000;
//        // creating each row
//        for (int i = 0; i < display.heightPixels / tileLength; i++) {
//            LinearLayout row = new LinearLayout(this);
//            row.setOrientation(LinearLayout.HORIZONTAL);
//            row.setId(id++);
//
//            // creating each block/column on the row
//            // replace R.drawable.heart with the path of the graphic for the tile
//            // maybe use conditional so for example if i == 2 (third row) and you want it
//            // to be a river, change this loop to have the river graphic? not sure if that
//            // is the most efficient. maybe theres a better way
//            for (int j = 0; i < display.widthPixels / tileLength; j++) {
//                ImageView tile = new ImageView(this);
//                tile.setBackground(this.getResources().getDrawable(R.drawable.heart));
//                row.addView(tile);
//            }
//        }

        // MAP USING BITMAP
        // what is the config? // stores each pixel with four bytes
        ImageView grid = findViewById(R.id.grid);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
//        bmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        int[] colors = new int[tileLength * tileLength];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.CYAN;
        }
        bmap = Bitmap.createBitmap(display.widthPixels, display.heightPixels, config);
        int row = 0;
        int col = 0;

        // to display correct graphics: maybe create a condition for which row you're on:
        // to access a certain row:
        // first pixel of the row = tileLength * number of the row
        // then for that row, set all the tile graphics to the correct one
        // there might be a more efficient way, thats just an idea

        // display the blocks on the bitmap // for my/our reference
        // for each row
        for (int i = 0; i < display.widthPixels; i += tileLength) {

            // for each column
            for (int j = 0; j < display.heightPixels; j += tileLength) {
                if ((int) (row + col) % 2 == 0 && (j + tileLength >= display.heightPixels)) {
                    bmap.setPixels(colors, 0, tileLength, i, j, tileLength, display.heightPixels - j);
                } else if ((int) (row + col) % 2 == 0 && (i + tileLength >= display.widthPixels)){
                    bmap.setPixels(colors, 0, display.widthPixels - i, i, j, display.widthPixels - i, tileLength);
                } else if ((int) (row + col) % 2 == 0) {
                    System.out.println("i + j: " + i + j);
                    bmap.setPixels(colors, 0, tileLength, i, j, tileLength, tileLength);
                }
                row++;
                }
            row = 0;
            col++;
        }

        // show which tile should be the starting tile
        int[] startColor = new int[tileLength * tileLength];
        for (int i = 0; i < startColor.length; i ++) {
            startColor[i] = Color.RED;
        }
        bmap.setPixels(startColor, 0, tileLength, tileLength * ((display.widthPixels / tileLength) / 2),
                tileLength * (display.heightPixels / tileLength - 1), tileLength, tileLength);
        grid.setImageBitmap(bmap);
    }
}
