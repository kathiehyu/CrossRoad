package com.example.crosstheroad;

import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameView extends SurfaceView implements Runnable {
    //    private Surface surface;
    private Thread thread;
    private boolean isPlaying;
    private int x = 0;
    private int y = 0;
    private Paint paint;
    private Background background1;
    static Character character;

    //    public GameView(Context context, AttributeSet attributeSet) {
    //        super(context, attributeSet);
    //        LayoutInflater lf = LayoutInflater.from(context);
    //        ViewGroup vg = new ViewGroup(context) {
    //            @Override
    //            protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
    //                //
    //            }
    //        };
    //        vg.addView(this);
    //        View v = lf.inflate(R.layout.activity_game_activity, vg);
    //        // butterknife bind?
    //        System.out.println("Creating GameView");
    //        background1 = new Background(getResources(), super.getContext());
    //        this.screenX = screenX;
    //        this.screenY = screenY;
    //        paint = new Paint();
    //        character = new Character(screenX, screenY, getResources());
    //    }

    public GameView(Context context) {
        super(context);
        background1 = new Background(getResources());
        paint = new Paint();
        character = new Character(x, y, getResources());
    }

    public static int getCharX() {
        return x;
    }

    public int getCharY() {
        return y;
    }

    public static  void setCharX(int xIn) {
        if (validateMovement(xIn, y)) {
            x = xIn;
        } // else : don't change x
    }

    public static void setCharY(int yIn) {
        if (validateMovement(x, yIn)) {
            y = yIn;
        }
    }

    private boolean validateMovement(int x, int y) {
        return !(x + Background.tileLength >= MainActivity.screenX
                || y + Background.tileLength >= MainActivity.screenY
                || x < 0 || y < 0);
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

    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);


            System.out.println("trying to draw character");
            assert Character.getChar() != null;
            System.out.println("x: " + Integer.toString(x));
            System.out.println("y: " + Integer.toString(y));
            canvas.drawBitmap(Character.getChar(), x, y, paint);

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
  
    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //        @Override
    //    protected void onCreate(Bundle savedInstanceState) {
    //        super.onCreate(savedInstanceState);
    //        setContentView(R.layout.activity_game_view);
    //        Point point = new Point();
    //        getWindowManager().getDefaultDisplay().getSize(point);
    //        surface = new Surface(this, point.x, point.y);
    //        setContentView(surface);
    //    }

}
