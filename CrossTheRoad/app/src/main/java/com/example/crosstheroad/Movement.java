package com.example.crosstheroad;

public class Movement {
<<<<<<< Updated upstream
    private static int x = 0;
    private static int y = 0;
    public static  void setCharX(int xIn) {
=======
    private int x = 0;
    private int y = 0;
    private int tileLength = Background.getTileLength();

    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCharX(int xIn) {
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public static boolean validateMovement(int x, int y) {
        return !(x + Background.getTileLength() >= MainActivity.getScreenX()
                || y + Background.getTileLength() >= MainActivity.getScreenY()
                || x < 0 || y < 0);
    }
=======
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

    public boolean collision(int x, int y) {
        int leftBound = this.x;
        int rightBound = this.x + tileLength;
        int upBound = this.y;
        int downBound = this.y + tileLength;
        // it has to be on the same row in order for there to be a collision
        if (y > upBound && y < downBound && x > leftBound && x < rightBound) {
            return true;
        }
        return false;
    }
>>>>>>> Stashed changes
}
