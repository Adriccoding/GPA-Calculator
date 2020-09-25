package com.example.gpa_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText g1, g2, g3, g4, g5;
    private ConstraintLayout myLayout;
    private Button calc;
    private TextView GPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g1 = (EditText) findViewById(R.id.Grade1);
        g2 = (EditText) findViewById(R.id.Grade2);
        g3 = (EditText) findViewById(R.id.Grade3);
        g4 = (EditText) findViewById(R.id.Grade4);
        g5 = (EditText) findViewById(R.id.Grade5);
        GPA = (TextView) findViewById(R.id.GPA);
        calc = (Button) findViewById(R.id.Calc);
        myLayout = (ConstraintLayout) findViewById(R.id.layout);
        calc.setOnClickListener(swap);
    }

    View.OnClickListener swap = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (g1.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Empty data for class one", Toast.LENGTH_LONG).show();
                return;
            }
            if (g2.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Empty data for class two", Toast.LENGTH_LONG).show();
                return;
            }
            if (g3.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Empty data for class three", Toast.LENGTH_LONG).show();
                return;
            }
            if (g4.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Empty data for class four", Toast.LENGTH_LONG).show();
                return;
            }
            if (g5.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "empty data for class five", Toast.LENGTH_LONG).show();
                return;
            }

            int tot = (Integer.parseInt(g1.getText().toString()) +
                    Integer.parseInt(g2.getText().toString()) +
                    Integer.parseInt(g3.getText().toString()) +
                    Integer.parseInt(g4.getText().toString()) +
                    Integer.parseInt(g5.getText().toString())) / 5;

            if (tot >= 80) {
                myLayout.setBackgroundColor(Color.GREEN);
            } else if (tot > 60 && tot <= 79) {
                myLayout.setBackgroundColor(Color.YELLOW);
            } else {
                myLayout.setBackgroundColor(Color.RED);
            }
            GPA.setText(String.valueOf(tot));
            calc.setText("Clear");}
    };
}

