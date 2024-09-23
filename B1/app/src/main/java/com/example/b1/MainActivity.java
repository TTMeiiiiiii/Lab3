package com.example.b1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText editA, editB;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = findViewById(R.id.editsoa);
        editB = findViewById(R.id.editsob);
        textResult = findViewById(R.id.textViewResult);

        Button buttonSum = findViewById(R.id.buttonSum);
        Button buttonDifference = findViewById(R.id.buttonDifference);
        Button buttonProduct = findViewById(R.id.buttonProduct);
        Button buttonQuotient = findViewById(R.id.buttonQuotient);
        Button buttonGCD = findViewById(R.id.buttonGCD);
        Button buttonExit = findViewById(R.id.buttonExit);

        buttonSum.setOnClickListener(v -> calculate('+'));
        buttonDifference.setOnClickListener(v -> calculate('-'));
        buttonProduct.setOnClickListener(v -> calculate('*'));
        buttonQuotient.setOnClickListener(v -> calculate('/'));
        buttonGCD.setOnClickListener(v -> calculateGCD());
        buttonExit.setOnClickListener(v -> finish());
    }

    private void calculate(char operation) {
        String inputA = editA.getText().toString();
        String inputB = editB.getText().toString();

        // Check for empty input
        if (inputA.isEmpty() || inputB.isEmpty()) {
            textResult.setText("Vui lòng nhập đầy đủ số A và B.");
            return;
        }

        int a = Integer.parseInt(inputA);
        int b = Integer.parseInt(inputB);

        double result;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = (double) a / b;
                } else {
                    textResult.setText("Không thể chia cho 0");
                    return;
                }
                break;
            default:
                return;
        }
        if (result % 1 == 0) {
            textResult.setText(String.valueOf((int) result)); // Chuyển đổi về số nguyên
        } else {
            textResult.setText(String.valueOf(result)); // Giữ nguyên số thập phân
        }
    }

    private void calculateGCD() {
        String inputA = editA.getText().toString();
        String inputB = editB.getText().toString();

        if (inputA.isEmpty() || inputB.isEmpty()) {
            textResult.setText("Vui lòng nhập đầy đủ số A và B.");
            return;
        }

        int a = Integer.parseInt(inputA);
        int b = Integer.parseInt(inputB);

        if (a == 0 && b == 0) {
            textResult.setText("Không có ước chung lớn nhất cho 0 và 0.");
            return;
        }

        int gcd = gcd(a, b);
        textResult.setText(String.valueOf(gcd));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}