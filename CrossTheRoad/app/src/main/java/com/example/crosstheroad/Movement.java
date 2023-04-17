package com.example.crosstheroad;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;

public class Movement {
    private float x = 0;
    private float y = 0;
    private int tileLength = Background.getTileLength();

    private static ObjectAnimator charAnimator;

//    public ObjectAnimator getCharAnimator() {
//        return charAnimator;
//    }
//
    private WaterMoveable pokemonOn;

    public WaterMoveable getPokemonOn() {
        return pokemonOn;
    }

    public void setPokemonOn(WaterMoveable p) {
        pokemonOn = p;
    }

    public static ObjectAnimator getCharAnimator() {
        return charAnimator;
    }

    public void setCharAnimator(ObjectAnimator oa) {
        charAnimator = oa;
        if (charAnimator == null){
            return;
        }
        charAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                if (charAnimator == null){
                    return;
                } else if (charAnimator.isPaused()) {
                    System.out.println("paused object animator");
                    //charAnimator.cancel();
                    charAnimator = null;
                    return;
                }

                float xPos = (float) charAnimator.getAnimatedValue();
                // if character moves off screen
                if (xPos >= MainActivity.getScreenX()) {
                    charAnimator.pause();
                    charAnimator = null;
                    GameActivity game = new GameActivity();
                    game.setStartConditions(true);
                    return;
                }
                x = xPos;
            }
        });
    }

    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCharX(float xIn) {
        if (validateMovement(xIn, y)) {
            x = xIn;
        } // else : don't change x
        // Character.getChar().setX(x);
    }

    public void setCharY(float yIn) {
        if (validateMovement(x, yIn)) {
            y = yIn;
        }
        // Character.getChar().setX(y);
    }
    public float getCharX() {
        return this.x;
    }

    public float getCharY() {
        return this.y;
    }


    public boolean validateMovement(float x, float y) {
        System.out.println("click");
        return !(x + this.tileLength > MainActivity.getScreenX()
                || y + this.tileLength >= MainActivity.getScreenY()
                || x < 0 || y < 0);
    }

    /**
     * This method moves the character 1 tile up if not out of bound.
     * @return true if moved
     */
    public boolean moveUp() {
        float newY = this.y - this.tileLength;
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
        float newY = this.y + this.tileLength;
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
        float newX = this.x - this.tileLength;
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
        float newX = this.x + this.tileLength;
        if (validateMovement(newX, this.y)) {
            this.x = newX;
            return true;
        }
        return false;
    }
}
