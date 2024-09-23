package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTinhBMI = findViewById(R.id.btnTinhBMI);
        EditText editChieuCao = findViewById(R.id.editChieuCao);
        EditText editCanNang = findViewById(R.id.editCanNang);
        EditText editBMI = findViewById(R.id.editBMI);
        EditText editChanDoan = findViewById(R.id.editChanDoan);
        EditText editTen = findViewById(R.id.editTen); // Thêm EditText cho tên

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTen.getText().toString(); // Lấy tên từ EditText
                if (ten.isEmpty()) {
                    editChanDoan.setText("Vui lòng nhập tên của bạn.");
                    return;
                }

                double H, W;
                try {
                    H = Double.parseDouble(editChieuCao.getText().toString());
                    W = Double.parseDouble(editCanNang.getText().toString());
                } catch (NumberFormatException e) {
                    editChanDoan.setText("Vui lòng nhập chiều cao và cân nặng hợp lệ.");
                    return;
                }

                double BMI = W / Math.pow(H, 2);
                String chanDoan;

                if (BMI < 18) {
                    chanDoan = "Bạn gầy";
                } else if (BMI <= 24.9) {
                    chanDoan = "Bạn bình thường";
                } else if (BMI <= 29.9) {
                    chanDoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chanDoan = "Bạn béo phì độ 2";
                } else {
                    chanDoan = "Bạn béo phì độ 3";
                }

                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChanDoan.setText(ten + ", " + chanDoan); // Hiển thị tên cùng với chẩn đoán
            }
        });
    }
}