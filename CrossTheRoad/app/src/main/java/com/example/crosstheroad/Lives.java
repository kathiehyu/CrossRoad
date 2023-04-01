package com.example.crosstheroad;

public class Lives implements LivesListener {
    private LivesListener listener;
    private int lives;
    public int get() {
        System.out.println(lives);
        return lives;
    }
    public void set(int newValue) {
        lives = newValue;
        System.out.printf("LISTENER NULL: %b\n", listener == null);
        if (listener != null) {
            listener.onNoLives();
        }
    }

    public void setListener(LivesListener listener) {
        this.listener = listener;
    }
    public void onNoLives() {
        if (lives <= 0) {

        }
    }
}
