package com.example.crosstheroad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class Surface extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying;
    private Background background1;
    private int screenX, screenY;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    private Move move;

    public Surface(Context context, int screenX, int screenY) {
        super(context);
        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1080 / screenX;
        screenRatioY = 2280 / screenY;

        move = new Move(screenY, getResources());

        background1 = new Background(screenX, screenY, getResources());
        paint = new Paint();
    }
    @Override
    public void run() {
        while(isPlaying) {
            update();
            draw();
            sleep();

        }

    }
    private void update() {
        if (move.goingUp){
            move.y -= 30 * screenRatioY;
        }
        if (move.goingDown) {
            move.y += 30 * screenRatioY;
        }
        if (move.y < 0){
            move.y = 0;
        }
        if (move.y > screenY - move.height){
            move.y = screenY - move.height;
        }


    }
    private void draw () {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(move.getMove(), move.x, move.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }
    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();


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
                move.goingUp = true;
            case MotionEvent.ACTION_DOWN:
                move.goingDown = true;
        }

        return true;
    }
}
