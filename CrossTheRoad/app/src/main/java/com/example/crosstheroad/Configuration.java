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
    private Button conti;
    protected static String editName;
    protected static RadioButton difficultyButton;
    protected static RadioButton charButton;

    private TextView name;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        //get player name from UI
        name = (TextView) findViewById(R.id.playername);
        editName = name.getText().toString();


        //difficulty level
        RadioGroup difficultyC = findViewById(R.id.difficultyChoice);
        difficultyC.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                difficultyButton = findViewById(difficultyC.getCheckedRadioButtonId());
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
        conti = (Button) findViewById(R.id.Continue);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.playername);
                editName = name.getText().toString();
                if (verifyName(editName) == false) {
                    Toast.makeText(Configuration.this,
                            "Name cannot be empty or white space", Toast.LENGTH_SHORT).show();
                }
                if (difficultyLevel(difficultyButton) == false) {
                    Toast.makeText(Configuration.this,
                            "Please choose a difficulty", Toast.LENGTH_SHORT).show();
                }
                if (characterChoice(charButton) == false) {
                    Toast.makeText(Configuration.this,
                            "Please choose a character", Toast.LENGTH_SHORT).show();
                }
                if (verifyName(editName) == true && difficultyLevel(difficultyButton) == true && characterChoice(charButton) == true) {
                    openConfiguration();
                }
            }
        });
    }

    public static boolean verifyName(String test) {
        if (test == editName){
            if (editName.isBlank()){
                return false;
            }
            return true;
        }
        else{
            editName = test;
            if (editName.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public static boolean difficultyLevel(RadioButton button) {
        if (button == null) {
            return false;
        }
        return true;
    }

    public static boolean characterChoice(RadioButton button) {
        if (button == null) {
            return false;
        }
        return true;
    }

    public void openConfiguration() {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }

}