package com.example.ex07;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity4 extends AppCompatActivity {
    EditText editText;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        editText = findViewById(R.id.editTextNumber);
        btn_back = findViewById(R.id.btn_back);
        Intent intent = getIntent();
        Bundle yourobject = intent.getBundleExtra("mybackage");
        int a = yourobject.getInt("a");
        int b = yourobject.getInt("b");
        String ketqua = "";
        if (a == 0 && b == 0) {
            ketqua = "Phuong trinh vo so nghiem";
        }
        else if (a == 0 && b != 0) {
            ketqua = "Phuong trinh vo nghiem";
        }
        else {
            DecimalFormat dcf = new DecimalFormat("0.##");
            ketqua= dcf.format(-b/a);
        }
        editText.setText(ketqua);
        btn_back.setOnClickListener(v -> {
            finish();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}