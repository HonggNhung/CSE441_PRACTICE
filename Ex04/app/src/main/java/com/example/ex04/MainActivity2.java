package com.example.ex04;

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

public class MainActivity2 extends AppCompatActivity {
    Button btnChuanDoan;
    EditText edtten, edtchieucao, edtcannang, edtBMI, edtChuanDoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        btnChuanDoan = findViewById(R.id.btnBMI);
        edtten = findViewById(R.id.edtten);
        edtchieucao = findViewById(R.id.edtchieucao);
        edtcannang = findViewById(R.id.edtcannang);
        edtBMI = findViewById(R.id.edtBMI);
        edtChuanDoan = findViewById(R.id.edtChuanDoan);
        btnChuanDoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(edtchieucao.getText()+ "");
                double W = Double.parseDouble(edtcannang.getText()+ "");
                double BMI = W / Math.pow(H, 2);
                String chandoan="";
                if(BMI < 18.5){
                    chandoan = "Gay";
                }else if(BMI < 24.9){
                    chandoan = "Binh thuong";
                }else if(BMI < 29.9){
                    chandoan = "Ban beo phi cap do 1";
                }else if(BMI < 34.9){
                    chandoan = "Ban beo phi cap do 2";
                }else
                {
                    chandoan = "Ban beo phi cap do 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                edtBMI.setText(dcf.format(BMI));
                edtChuanDoan.setText(chandoan);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}