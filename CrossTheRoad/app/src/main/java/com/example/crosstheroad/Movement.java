package com.example.crosstheroad;

public class Movement {
    private static int x = 0;
    private static int y = 0;
    public static  void setCharX(int xIn) {
        if (validateMovement(xIn, y)) {
            x = xIn;
        } // else : don't change x
    }

    public static void setCharY(int yIn) {
        if (validateMovement(x, yIn)) {
            y = yIn;
        }
    }
    public static int getCharX() {
        return x;
    }

    public static int getCharY() {
        return y;
    }

    public static boolean validateMovement(int x, int y) {
        return !(x + Background.getTileLength() >= MainActivity.getScreenX()
                || y + Background.getTileLength() >= MainActivity.getScreenY()
                || x < 0 || y < 0);
    }
}
