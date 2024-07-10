package com.example.numberguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    private Button buttonStart;
    private RadioButton radioButton1,radioButton2,radioButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonStart = findViewById(R.id.buttonStart);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                if (!radioButton1.isChecked() && !radioButton2.isChecked() && !radioButton3.isChecked()){

                    Snackbar.make(view,"Please select a number of digits",Snackbar.LENGTH_LONG).show();
                }
                else {
                    if (radioButton1.isChecked()){
                        intent.putExtra("two",true);
                    }
                    if (radioButton2.isChecked()){
                        intent.putExtra("three",true);
                    }
                    if (radioButton3.isChecked()){
                        intent.putExtra("four",true);
                    }

                    startActivity(intent);
                }

            }
        });

    }
}