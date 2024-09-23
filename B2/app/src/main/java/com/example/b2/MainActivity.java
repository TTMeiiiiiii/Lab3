package com.example.b2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText txtFar, txtCel;
    private Button btnFar, btnCel, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFar = findViewById(R.id.txtFar);
        txtCel = findViewById(R.id.txtCel);
        btnFar = findViewById(R.id.btnFar);
        btnCel = findViewById(R.id.btnCel);
        btnClear = findViewById(R.id.btnClear);

        btnFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String farValue = txtFar.getText().toString();
                if (!farValue.isEmpty()) {
                    try {
                        double fahrenheit = Double.parseDouble(farValue);
                        double celsius = (fahrenheit - 32) * 5 / 9;
                        txtCel.setText(String.format("%.2f", celsius));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị hợp lệ cho Fahrenheit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celValue = txtCel.getText().toString();
                if (!celValue.isEmpty()) {
                    try {
                        double celsius = Double.parseDouble(celValue);
                        double fahrenheit = celsius * 9 / 5 + 32;
                        txtFar.setText(String.format("%.2f", fahrenheit));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập giá tr hợp lệ cho Celsius", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtFar.setText("");
                txtCel.setText("");
            }
        });
    }
}