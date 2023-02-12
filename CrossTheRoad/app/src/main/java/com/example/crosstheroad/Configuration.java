package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Configuration extends AppCompatActivity {
    private Button conti;
    protected static String editName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        conti = (Button) findViewById(R.id.Continue);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkName()) {
                    openConfiguration();
                }
            }
        });
    }

    public void openConfiguration (){
        Intent intent = new Intent (this, GameScreen.class);
        startActivity(intent);
    }

    public boolean checkName() {
        EditText name = (EditText) findViewById(R.id.playername);
        editName = name.getText().toString();
        if (editName.isBlank()) {
            return false;
        }
        return true;
    }

}