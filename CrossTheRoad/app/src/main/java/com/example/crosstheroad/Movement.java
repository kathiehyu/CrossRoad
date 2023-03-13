package com.example.crosstheroad;

public class Movement {
    private static int x = 0;
    private static int y = 0;
    private static int tileLength = Background.getTileLength();
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
        return !(x + tileLength > MainActivity.getScreenX()
                || y + tileLength >= MainActivity.getScreenY()
                || x < 0 || y < 0);
    }

    /**
     * This method moves the character 1 tile up if not out of bound.
     * @return true if moved
     */
    public static boolean moveUp() {
        int newY = y - tileLength;
        if (validateMovement(x, newY)) {
            y = newY;
            return true;
        }
        return false;
    }

    /**
     * This method moves the character 1 tile down if not out of bound.
     * @return true if moved
     */
    public static boolean moveDown() {
        int newY = y + tileLength;
        if (validateMovement(x, newY)) {
            y = newY;
            return true;
        }
        return false;
    }

    /**
     * This method moves the character 1 tile to the left if not out of bound.
     * @return true if moved
     */
    public static boolean moveLeft() {
        int newX = x - tileLength;
        if (validateMovement(newX, y)) {
            x = newX;
            return true;
        }
        return false;
    }

    /**
     * This method moves the character 1 tile to the right if not out of bound.
     * @return true if moved
     */
    public static boolean moveRight() {
        int newX = x + tileLength;
        if (validateMovement(newX, y)) {
            x = newX;
            return true;
        }
        return false;
    }
}
