package com.example.crosstheroad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.crosstheroad.R;

public class Background {
    int x = 0, y = 0;
    static int screenX, screenY;
    static Bitmap background;
    static int widthInTiles = 7;
    static int tileLength;
    private Context context;

    Background (Resources res, Context context) {
        background = createBitMap();
        this.context = context;

//        background = BitmapFactory.decodeResource(res, R.drawable.game_background);
//        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }

    private Bitmap createBitMap() {

        // size of screen
        screenX = MainActivity.screenX;
        screenY = MainActivity.screenY;

        // number of tiles across screen (determines size of tiles)
        tileLength = screenX / widthInTiles;

        // MAP USING BITMAP
//        ImageView grid = findViewById(R.id.grid);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
//        bmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);

        // creating cyan checkerboard for tile visualization
        int[] riverColors = new int[tileLength * tileLength];
        for (int i = 0; i < riverColors.length; i++) {
            riverColors[i] = Color.BLUE;
        }

        int[] safeColors = new int[tileLength * tileLength];
        for (int i = 0; i < safeColors.length; i++) {
            safeColors[i] = Color.YELLOW;
        }

        int[] roadColors = new int[tileLength * tileLength];
        for (int i = 0; i < roadColors.length; i++) {
            roadColors[i] = Color.BLACK;
        }

        int[] goalColors = new int[tileLength * tileLength];
        for (int i = 0; i < goalColors.length; i++) {
            goalColors[i] = Color.GREEN;
        }

        int[][] tileColors = getColors(context);

        Bitmap bmap;
        bmap = Bitmap.createBitmap(screenX, screenY, config);
        int row = 0;
        int col = 0;

        // to display correct graphics: maybe create a condition for which row you're on:
        // to access a certain row:
        // first pixel of the row = tileLength * number of the row
        // then for that row, set all the tile graphics to the correct one
        // there might be a more efficient way, thats just an idea


        // display the blocks on the bitmap // for my/our reference
        // for each row
        for (int i = 0; i < screenX; i += tileLength) {

            // for each column
            for (int j = 0; j < screenY; j += tileLength) {
                // first row: goal
                if (row == 0) {
                    // if rightmost tile
                    if (i + tileLength >= screenX) {
                        bmap.setPixels(goalColors, 0, screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(goalColors, 0, tileLength, i, j, tileLength, tileLength);
                    }
                    // safe tiles
                } else if (row == 6 || row == 11 || row == 12) {
                    if (j + tileLength >= screenY && i + tileLength >= screenX) {
                        bmap.setPixels(safeColors, 0, screenX - i, i, j, screenX - i, screenY - j);
                    } else if (j + tileLength >= screenY) {
                        bmap.setPixels(safeColors, 0, tileLength, i, j, tileLength, screenY - j);
                    } else if (i + tileLength >= screenX){
                        bmap.setPixels(safeColors, 0, screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(safeColors, 0, tileLength, i, j, tileLength, tileLength);
                    }
                    // river tiles
                } else if (row > 0 && row < 6) {
                    // if rightmost tile
                    if (i + tileLength >= screenX) {
                        bmap.setPixels(tileColors[2], 0, screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(tileColors[2], 0, tileLength, i, j, tileLength, tileLength);
                    }
                    // road tiles
                } else {
                    // if rightmost tile
                    if (i + tileLength >= screenX) {
                        bmap.setPixels(roadColors, 0, screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(roadColors, 0, tileLength, i, j, tileLength, tileLength);
                    }
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
        bmap.setPixels(startColor, 0, tileLength, tileLength * ((screenX / tileLength) / 2),
                tileLength * (screenY / tileLength - 1), tileLength, tileLength);
//        grid.setImageBitmap(bmap);

        return bmap;
    }

    private int[][] getColors(Context context) {
        // 0 = safe, 1 = road, 2 = river, 3 = goal
        Bitmap river = MainActivity.riverBmap;
        int[][] tileColors = new int[4][];
//        int[] riverColors = new int[Background.tileLength * Background.tileLength];
//        river.getPixels(riverColors, 0, Background.tileLength, 0, 0,
//                Background.tileLength, Background.tileLength);
        int[] riverColors = new int[tileLength * tileLength];
        river.getPixels(riverColors, 0, tileLength, 0, 0,
                tileLength, tileLength);
        tileColors[2] = riverColors;
        return tileColors;
    }
}
