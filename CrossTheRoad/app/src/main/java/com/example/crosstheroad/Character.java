package com.example.crosstheroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Character {
    int x, y, width, height;
    static Bitmap character;

    public boolean goingUp = false;
    public boolean goingDown = false;
    public boolean goingRight = false;
    public boolean goingLeft = false;

    Character(int screenX, int screenY, Resources res) {

        // getting the character to display
        if (Configuration.charButton.getId() == R.id.character1) {
            character = BitmapFactory.decodeResource(res, R.drawable.character_1);
        }
        else if (Configuration.charButton.getId() == R.id.character2){
            character = BitmapFactory.decodeResource(res, R.drawable.c2);
        }
        else {
            character = BitmapFactory.decodeResource(res, R.drawable.character_3);
        }

        int tileLength = screenX / Background.widthInTiles;

        width = tileLength;
        height = tileLength;

        character = Bitmap.createScaledBitmap(character, tileLength, tileLength, false);

        // starting position
        x = tileLength * ((screenX / tileLength) / 2);
        y = tileLength * (screenY / tileLength - 1);

    }

    public Bitmap getChar() {
        return character;
    }
}
