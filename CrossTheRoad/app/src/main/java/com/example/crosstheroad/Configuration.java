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
import android.widget.Toast;

public class Configuration extends AppCompatActivity {
    private Button conti;
    protected static String editName;
    protected static RadioButton difficultyButton;
    protected static RadioButton charButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        RadioGroup difficultyC = findViewById(R.id.difficultyChoice);
        difficultyC.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int difficulty = difficultyC.getCheckedRadioButtonId();
                difficultyButton = findViewById(difficultyC.getCheckedRadioButtonId());
            }
        });

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

        conti = (Button) findViewById(R.id.Continue);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.playername);
                editName = name.getText().toString();
                if (editName.length() == 0) {
                    Toast.makeText(Configuration.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                }
                if (difficultyButton == null) {
                    Toast.makeText(Configuration.this, "Please choose a difficulty", Toast.LENGTH_SHORT).show();
                }
                if (charButton == null) {
                    Toast.makeText(Configuration.this, "Please choose a character", Toast.LENGTH_SHORT).show();
                }
                if (editName.length() != 0 && !(difficultyButton == null) && !(charButton == null)) {
                    openConfiguration();
                }
            }
        });
    }

    public void openConfiguration() {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }

}