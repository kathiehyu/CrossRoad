package com.example.crosstheroad;

import android.animation.ObjectAnimator;

public class Movement {
    private int x = 0;
    private int y = 0;
    private int tileLength = Background.getTileLength();

    private ObjectAnimator charAnimator;

    public ObjectAnimator getCharAnimator() {
        return charAnimator;
    }

    public void setCharAnimator(ObjectAnimator oa) {
        charAnimator = oa;
    }

    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCharX(int xIn) {
        if (validateMovement(xIn, y)) {
            x = xIn;
        } // else : don't change x
    }

    public void setCharY(int yIn) {
        if (validateMovement(x, yIn)) {
            y = yIn;
        }
    }
    public int getCharX() {
        return this.x;
    }

    public int getCharY() {
        return this.y;
    }


    public boolean validateMovement(int x, int y) {
        return !(x + this.tileLength > MainActivity.getScreenX()
                || y + this.tileLength >= MainActivity.getScreenY()
                || x < 0 || y < 0);
    }

    /**
     * This method moves the character 1 tile up if not out of bound.
     * @return true if moved
     */
    public boolean moveUp() {
        int newY = this.y - this.tileLength;
        if (validateMovement(this.x, newY)) {
            this.y = newY;
            return true;
        }
        return false;
    }

    /**
     * This method moves the character 1 tile down if not out of bound.
     * @return true if moved
     */
    public boolean moveDown() {
        int newY = this.y + this.tileLength;
        if (validateMovement(this.x, newY)) {
            this.y = newY;
            return true;
        }
        return false;
    }

    /**
     * This method moves the character 1 tile to the left if not out of bound.
     * @return true if moved
     */
    public boolean moveLeft() {
        int newX = this.x - this.tileLength;
        if (validateMovement(newX, this.y)) {
            this.x = newX;
            return true;
        }
        return false;
    }

    /**
     * This method moves the character 1 tile to the right if not out of bound.
     * @return true if moved
     */
    public boolean moveRight() {
        int newX = this.x + this.tileLength;
        if (validateMovement(newX, this.y)) {
            this.x = newX;
            return true;
        }
        return false;
    }
}
