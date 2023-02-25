package com.example.crosstheroad;

import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;

public class GameView extends SurfaceView implements Runnable {
//    private Surface surface;
    private Thread thread;
    private boolean isPlaying;
    int screenX, screenY;
    private Paint paint;
    private Background background1;
    private Character character;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        background1 = new Background(getResources());
        this.screenX = screenX;
        this.screenY = screenY;
        paint = new Paint();
        character = new Character(screenX, screenY, getResources());
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //control touching motion
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                character.goingUp = true;
            case MotionEvent.ACTION_DOWN:
                character.goingDown = true;
        }

        return true;
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            try {
                sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void update() {
        if (character.goingUp){
            character.y -= Background.tileLength;
        }
        if (character.goingDown) {
            character.y += Background.tileLength;
        }
        if (character.y < 0){
            character.y = 0;
        }
        if (character.y > screenY - character.height){
            character.y = screenY - character.height;
        }
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);

            canvas.drawBitmap(character.getChar(), character.x, character.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }
    private void sleep() throws InterruptedException {
        // 60 fps
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected void resume() {
//        super.onResume();
//        surface.resume();
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game_view);
//        Point point = new Point();
//        getWindowManager().getDefaultDisplay().getSize(point);
//        surface = new Surface(this, point.x, point.y);
//        setContentView(surface);
//
//
//    }

}
