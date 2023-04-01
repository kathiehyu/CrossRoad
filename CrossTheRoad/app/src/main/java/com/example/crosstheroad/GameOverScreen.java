package com.example.crosstheroad;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Button restart = (Button) findViewById(R.id.restart_game);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfiguration();
            }
        });

        Button exit = (Button) findViewById(R.id.exit_game);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });
    }

    private void openConfiguration() {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }
}
