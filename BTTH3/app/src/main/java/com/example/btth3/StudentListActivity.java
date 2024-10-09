package com.example.btth3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        Student student = (Student) getIntent().getSerializableExtra("student");

        String details = "ID: " + student.getId() + "\n"
                + "Fullname: " + student.getFullName() + "\n"
                + "Gender: " + student.getGender() + "\n"
                + "GPA: " + student.getGpa() + "\n"
                + "Major: " + student.getMajor() + "\n"
                + "Email: " + student.getEmail() + "\n"
                + "Birth Date: " + student.getBirthDate() + "\n"
                + "Address: " + student.getAddress();

    }
}

