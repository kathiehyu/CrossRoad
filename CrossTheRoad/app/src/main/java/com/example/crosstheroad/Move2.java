package com.example.crosstheroad;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;

public class Move2 extends AppCompatActivity implements View.OnTouchListener {
    private ImageView char1;
    private FrameLayout frame;
    private boolean up, down, left, right;
    private final Timer timer = new Timer();
    private final Handler handler = new Handler();

    @SuppressLint({"MissingInflatedId", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //might be the wrong view but idk
        setContentView(R.layout.activity_game_view);

        // character_1 is the file to identify the chosen character I would prob add a
        // string so it can be modified by if else statements to get the chosen character
        //String x = "character_1"; but this doesn't work so might need to like copy
        // and paste this code three times lol
        char1 = findViewById(R.id.character);
        frame = findViewById(R.id.frame);
        getResources().getDrawable(R.drawable.character_1);
        getResources().getDrawable(R.drawable.character_1);
        findViewById(R.id.upButton).setOnTouchListener(this);
        findViewById(R.id.downButton).setOnTouchListener(this);
        findViewById(R.id.leftButton).setOnTouchListener(this);
        findViewById(R.id.rightButton).setOnTouchListener(this);

        //changing the speed of the character
        timer.schedule(new TimerTask() {
            public void run() {
                handler.post(() -> pos());
            }
        }, 0, 30);
    }

    //moving the character
    public void pos() {

        float moveX = char1.getX();
        float moveY = char1.getY();
        //up
        if (up) moveY -= 30;
        //down
        if (down) moveY += 30;
        //left
        if (left)
            moveX -= 30;
        //right
        if (right)
            moveX += 30;

        //to keep character on the screen
        moveY = Math.min(Math.max(moveY, 0), frame.getHeight() - char1.getHeight());
        moveX = Math.min(Math.max(moveX, 0), frame.getWidth() - char1.getWidth());
        char1.setX(moveX);
        char1.setY(moveY);

    }

    @SuppressLint({"ClickableViewAccessibility", "NonConstantResourceId"})
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        up = (view.getId() == R.id.upButton && motionEvent.getAction() == MotionEvent.ACTION_DOWN);
        down = (view.getId() == R.id.downButton && motionEvent.getAction() == MotionEvent.ACTION_DOWN);
        left = (view.getId() == R.id.leftButton && motionEvent.getAction() == MotionEvent.ACTION_DOWN);
        right = (view.getId() == R.id.rightButton && motionEvent.getAction() == MotionEvent.ACTION_DOWN);
        return false;
    }

}
