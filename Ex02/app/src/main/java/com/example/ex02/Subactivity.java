package com.example.ex02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Subactivity extends AppCompatActivity {
    Button btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub super.onCreate(savedInstanceState); setContentView(R.layout.activity_sub); btnok = findViewById(R.id.btnok);
        super.onCreate(savedInstanceState);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub finish();
            }
        });
    }
}

