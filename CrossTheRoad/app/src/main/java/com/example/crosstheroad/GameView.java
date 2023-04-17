package com.example.crosstheroad;

import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameView extends SurfaceView implements Runnable {
    //    private Surface surface;
    private Thread thread;
    private boolean isPlaying;

    private Paint paint;
    private Background background1;
    private static Character character;

    private Movement movement;

    public GameView(Context context) {
        super(context);
        background1 = new Background();
        paint = new Paint();
        character = new Character(getResources(), context);
        movement = new Movement();
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
        System.out.println("location y: " +Character.getChar().getY());
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.getBackground(),
                    background1.getX(), background1.getY(), paint);


            //System.out.println("trying to draw character");
            assert Character.getChar() != null;
            // canvas.drawBitmap(Character.getChar(), movement.getCharX(), movement.getCharY(), paint);
            Character.getChar().setX(movement.getCharX());
            Character.getChar().setY(movement.getCharY());

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

    public static Character getCharacter() {
        return character;
    }

    public Movement getMovement() {
        return movement;
    }
}
