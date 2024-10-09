package com.example.btth3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    private ImageView genderImageView;
    private TextView idTextView;
    private TextView fullNameTextView;
    private TextView birthDateTextView;
    private TextView addressTextView;
    private TextView emailTextView;
    private TextView majorTextView;
    private TextView gpaTextView;
    private TextView yearTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        // Khởi tạo các View
        genderImageView = findViewById(R.id.genderImageView);
        idTextView = findViewById(R.id.idTextView);
        fullNameTextView = findViewById(R.id.fullNameTextView);
        birthDateTextView = findViewById(R.id.birthDateTextView);
        addressTextView = findViewById(R.id.addressTextView);
        emailTextView = findViewById(R.id.emailTextView);
        majorTextView = findViewById(R.id.majorTextView);
        gpaTextView = findViewById(R.id.gpaTextView);
        yearTextView = findViewById(R.id.yearTextView);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String studentId = intent.getStringExtra("id");
        String fullName = intent.getStringExtra("full_name");
        String birthDate = intent.getStringExtra("birth_date");
        String address = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");
        String major = intent.getStringExtra("major");
        double gpa = intent.getDoubleExtra("gpa", 0.0);
        String gender = intent.getStringExtra("gender");
        String year = intent.getStringExtra("year"); // Năm học

        // Hiển thị thông tin sinh viên
        idTextView.setText(studentId);
        fullNameTextView.setText(fullName);
        birthDateTextView.setText(birthDate);
        addressTextView.setText(address);
        emailTextView.setText(email);
        majorTextView.setText(major);
        gpaTextView.setText(String.valueOf(gpa));
        yearTextView.setText(year);

        // Hiển thị ảnh đại diện theo giới tính
        if ("Nam".equals(gender)) {
            genderImageView.setImageResource(R.drawable.ic_male);
        } else {
            genderImageView.setImageResource(R.drawable.ic_female);
        }
    }
}
