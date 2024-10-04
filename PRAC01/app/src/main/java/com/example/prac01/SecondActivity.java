package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private EditText edtName,edtGpa;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        edtName = findViewById(R.id.edtName);
        edtGpa = findViewById(R.id.edtGpa);
        btnSubmit = findViewById(R.id.btnSubmit);

        //Bat su kien
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String gpa = edtGpa.getText().toString();
                Intent Result = new Intent();
                Result.putExtra("name_key",name);
                Result.putExtra("gpa_key",gpa);
                setResult(RESULT_OK,Result);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
