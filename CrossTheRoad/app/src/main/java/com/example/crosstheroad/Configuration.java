package com.example.crosstheroad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Configuration extends AppCompatActivity {
    protected static String inputName;
    protected static RadioButton selectedDifficulty;
    protected static RadioButton charButton;
    private TextView name;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        //get player name from UI
        name = (TextView) findViewById(R.id.playername);
        inputName = name.getText().toString();


        //difficulty level
        RadioGroup difficultyC = findViewById(R.id.difficultyChoice);
        difficultyC.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedDifficulty = findViewById(difficultyC.getCheckedRadioButtonId());
            }
        });

        //character
        RadioGroup charac = findViewById(R.id.Select_Character);
        charac.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                charButton = findViewById(charac.getCheckedRadioButtonId());
                charButton.setBackgroundColor(Color.parseColor("lightgrey"));

                if (Configuration.charButton.getId() == R.id.character1) {
                    findViewById(R.id.character2).setBackgroundColor(0x0);
                    findViewById(R.id.character3).setBackgroundColor(0x0);
                } else if (Configuration.charButton.getId() == R.id.character2) {
                    findViewById(R.id.character1).setBackgroundColor(0x0);
                    findViewById(R.id.character3).setBackgroundColor(0x0);
                } else {
                    findViewById(R.id.character2).setBackgroundColor(0x0);
                    findViewById(R.id.character1).setBackgroundColor(0x0);
                }
            }
        });

        //display error message
        Button conti = (Button) findViewById(R.id.Continue);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.playername);
                inputName = name.getText().toString();
                if (!verifyName(inputName)) {
                    Toast.makeText(Configuration.this,
                            "Name cannot be empty or white space", Toast.LENGTH_SHORT).show();
                }
                if (!difficultyLevel(selectedDifficulty)) {
                    Toast.makeText(Configuration.this,
                            "Please choose a difficulty", Toast.LENGTH_SHORT).show();
                }
                if (!characterChoice(charButton)) {
                    Toast.makeText(Configuration.this,
                            "Please choose a character", Toast.LENGTH_SHORT).show();
                }
                if (verifyName(inputName) && difficultyLevel(selectedDifficulty)
                        && characterChoice(charButton)) {
                    openGameScreen();
                }
            }
        });
    }

    public static boolean verifyName(String test) {
        if (test == null || test.isBlank()) {
            return false;
        } else {
            inputName = test;
            return true;
        }
    }

    public static boolean difficultyLevel(RadioButton button) {
        return (button != null);
    }

    public static boolean characterChoice(RadioButton button) {
        return (button != null); }

    public void openGameScreen() {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }

}