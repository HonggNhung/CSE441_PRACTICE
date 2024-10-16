package com.example.ex04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editText2 = findViewById(R.id.edtc);
        EditText editText1 = findViewById(R.id.edtf);
        Button button2 = findViewById(R.id.btnf);
        Button button1 = findViewById(R.id.btnc);
        button2.setOnClickListener(v -> {
            double celsius = Double.parseDouble(editText2.getText().toString());
            double fahrenheit = (celsius * 9 / 5) + 32;
            editText1.setText(String.valueOf(fahrenheit));
        });
        button1.setOnClickListener(v -> {
            double fahrenheit = Double.parseDouble(editText1.getText().toString());
            double celsius = (fahrenheit - 32) * 5 / 9;
            editText2.setText(String.valueOf(celsius));
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}