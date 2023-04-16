package com.example.crosstheroad;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Character {
    // private static Bitmap character;
    private static ImageView character;

    Character(Resources res, Context context) {

        // getting the character that will display
        if (Configuration.charButton.getId() == R.id.character1) {
            character = new ImageView(context);
            character.setImageDrawable(res.getDrawable(R.drawable.character_1));

            // character = BitmapFactory.decodeResource(res, R.drawable.character_1);
        } else if (Configuration.charButton.getId() == R.id.character2) {
            character = new ImageView(context);
            character.setImageDrawable(res.getDrawable(R.drawable.c2));
            // character = BitmapFactory.decodeResource(res, R.drawable.c2);
        } else {
            character = new ImageView(context);
            character.setImageDrawable(res.getDrawable(R.drawable.character_3));
            // character = BitmapFactory.decodeResource(res, R.drawable.character_3);
        }

        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                Background.getTileLength(), Background.getTileLength());

        character.setLayoutParams(frameParams);
        character.setZ(9);
//        character = Bitmap.createScaledBitmap(character, Background.getTileLength(),
//                Background.getTileLength(), false);
    }

//    public static Bitmap getChar() {
//        return character;
//    }
    public static ImageView getChar() {
        return character;
    }
}
