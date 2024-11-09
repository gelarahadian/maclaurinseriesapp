package com.example.maclaurinseriesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputX, inputDegree;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputX = findViewById(R.id.inputX);
        inputDegree = findViewById(R.id.inputDegree);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculateMaclaurin();
            }
        });
    }

    private void calculateMaclaurin() {
        double x = Double.parseDouble(inputX.getText().toString());
        int degree = Integer.parseInt(inputDegree.getText().toString());

        StringBuilder resultBuilder = new StringBuilder("Result MacLaurin Series:\n");
        double sum = 0.0;

        for(int i = 0; i < degree; i++) {
            double term = Math.pow(x, i) / factorial(i);
            sum += term;
            resultBuilder.append("Order to-").append(i).append(": ").append(term).append("\n");
        }

        resultBuilder.append("Total Sum: ").append(sum);
        resultText.setText(resultBuilder.toString());
    }

    private double factorial(int n) {
        if ( n == 0) return 1;
        double result = 1;
        for (int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }
}