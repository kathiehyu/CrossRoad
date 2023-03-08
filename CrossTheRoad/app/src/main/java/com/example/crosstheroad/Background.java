package com.example.crosstheroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Background {
    private int x = 0;
    private int y = 0;
    private static int screenX;
    private static int screenY;
    private static Bitmap background;

    // change to make blocks smaller/larger (should be an odd number
    // so the character stays in the middle of the screen)
    private static int widthInTiles = 7;
    private static int tileLength;

    // row numbers for each of the 'tiles'
    private static List<Integer> riverRows = Arrays.asList(1, 2, 3, 4, 5);
    private static List<Integer> safeRows = Arrays.asList(6, 11, 12);
    private static List<Integer> goalRows = Arrays.asList(0);
    private static  List<Integer> roadRows = Arrays.asList(7, 8, 9, 10);

    public static List<Integer> getRiverRows() {
        return riverRows;
    }

    public static List<Integer> getSafeRows() {
        return safeRows;
    }

    public static List<Integer> getGoalRows() {
        return goalRows;
    }

    public static List<Integer> getRoadRows() {
        return roadRows;
    }

    Background(Resources res) {
        background = createBitMap();
    }

    private Bitmap createBitMap() {

        // size of screen
        screenX = MainActivity.getScreenX();
        screenY = MainActivity.getScreenY();

        // number of tiles across screen (determines size of tiles)
        tileLength = screenX / widthInTiles;
        System.out.println("TILELENGTH: " + tileLength);

        // MAP USING BITMAP
        Bitmap.Config config = Bitmap.Config.ARGB_8888;

        int[][] tileColors = getColors();

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
                if (goalRows.contains(row)) {
                    // if rightmost tile
                    if (i + tileLength >= screenX) {
                        bmap.setPixels(tileColors[3], 0,
                                screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(tileColors[3], 0,
                                tileLength, i, j, tileLength, tileLength);
                    }
                    // safe tiles
                } else if (safeRows.contains(row)) {
                    if (j + tileLength >= screenY && i + tileLength >= screenX) {
                        bmap.setPixels(tileColors[0], 0,
                                screenX - i, i, j, screenX - i,
                                screenY - j);
                    } else if (j + tileLength >= screenY) {
                        bmap.setPixels(tileColors[0], 0,
                                tileLength, i, j, tileLength, screenY - j);
                    } else if (i + tileLength >= screenX) {
                        bmap.setPixels(tileColors[0], 0,
                                screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(tileColors[0], 0,
                                tileLength, i, j, tileLength, tileLength);
                    }
                    // river tiles
                } else if (riverRows.contains(row)) {
                    // if rightmost tile
                    if (i + tileLength >= screenX) {
                        bmap.setPixels(tileColors[2], 0,
                                screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(tileColors[2], 0,
                                tileLength, i, j, tileLength, tileLength);
                    }
                    // road tiles
                } else {
                    // if rightmost tile
                    if (i + tileLength >= screenX) {
                        bmap.setPixels(tileColors[1], 0,
                                screenX - i, i, j, screenX - i, tileLength);
                    } else {
                        bmap.setPixels(tileColors[1], 0,
                                tileLength, i, j, tileLength, tileLength);
                    }
                }
                row++;
            }
            row = 0;
            col++;
        }

        // show which tile should be the starting tile
        int[] startColor = new int[tileLength * tileLength];
        for (int i = 0; i < startColor.length; i++) {
            startColor[i] = Color.RED;
        }
        bmap.setPixels(startColor, 0, tileLength,
                tileLength * ((screenX / tileLength) / 2),
                tileLength * (screenY / tileLength - 1), tileLength, tileLength);

        return bmap;
    }

    private int[][] getColors() {
        // 0 = safe, 1 = road, 2 = river, 3 = goal
        Bitmap river = MainActivity.getRiverBmap();
        Bitmap safe = MainActivity.getSandBmap();
        Bitmap grass = MainActivity.getGrassBmap();
        Bitmap road = MainActivity.getRoadBmap();
        int[][] tileColors = new int[4][];
        int[] safeColors = new int[tileLength * tileLength];
        safe.getPixels(safeColors, 0, tileLength, 0, 0,
                tileLength, tileLength);
        tileColors[0] = safeColors;

        int row = 1;

        int[] roadColors = new int[tileLength * tileLength];
        road.getPixels(roadColors, 0, tileLength,
                0, 0, tileLength, tileLength);
        tileColors[1] = roadColors;

        int[] riverColors = new int[tileLength * tileLength];
        river.getPixels(riverColors, 0, tileLength, 0, 0,
                tileLength, tileLength);
        tileColors[2] = riverColors;

        int[] goalColors = new int[tileLength * tileLength];
        grass.getPixels(goalColors, 0, tileLength, 0, 0,
                tileLength, tileLength);
        tileColors[3] = goalColors;
        return tileColors;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getScreenX() {
        return screenX;
    }

    public static int getScreenY() {
        return screenY;
    }

    public Bitmap getBackground() {
        return background;
    }

    public static int getWidthInTiles() {
        return widthInTiles;
    }

    public static int getTileLength() {
        return tileLength;
    }
}
