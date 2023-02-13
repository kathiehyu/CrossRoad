package com.example.crosstheroad;

import android.content.Context;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying;

    public GameView(Context context) {
        super(context);
    }

    @Override
    public void run() {
        while (isPlaying) {
            isPlaying = true;
        }

    }


    public void resume() {
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

}
