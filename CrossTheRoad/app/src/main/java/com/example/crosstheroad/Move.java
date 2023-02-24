package com.example.crosstheroad;

import static com.example.crosstheroad.Surface.screenRatioX;
import static com.example.crosstheroad.Surface.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Move {
    public boolean goingUp = false;
    public boolean goingDown = false;
    public boolean goingRight = false;
    public boolean goingLeft = false;
    int x, y, width, height, moveCounter;
    Bitmap move;
    GameScreen charac = new GameScreen();
    Move (int screenY, Resources res) {
        if (Configuration.charButton.getId() == R.id.character1) {
            move = BitmapFactory.decodeResource(res, R.drawable.character_1);
        }
        else if (Configuration.charButton.getId() == R.id.character2){
            move = BitmapFactory.decodeResource(res, R.drawable.c2);
        }
        else {
            move = BitmapFactory.decodeResource(res, R.drawable.character_3);
        }
        width = move.getWidth();
        height = move.getHeight();

        width /= 20;
        height /= 20;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        move = Bitmap.createScaledBitmap(move, width, height, false);
        y = screenY /2;

    }
    Bitmap getMove() {
        if (moveCounter == 0){
            moveCounter++;
            return move;
        }
        moveCounter--;
        return move;
    }
}
