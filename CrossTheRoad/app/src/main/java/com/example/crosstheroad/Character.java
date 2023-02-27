package com.example.crosstheroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Character {
    private static Bitmap character;

    Character(int screenX, int screenY, Resources res) {

        // getting the character that will display
        if (Configuration.charButton.getId() == R.id.character1) {
            character = BitmapFactory.decodeResource(res, R.drawable.character_1);
        } else if (Configuration.charButton.getId() == R.id.character2){
            character = BitmapFactory.decodeResource(res, R.drawable.c2);
        } else {
            character = BitmapFactory.decodeResource(res, R.drawable.character_3);
        }

        character = Bitmap.createScaledBitmap(character, Background.tileLength, Background.tileLength, false);
    }

    public static Bitmap getChar() {
        return character;
    }
}
