package com.example.btth3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Đọc dữ liệu từ file JSON
        studentList = loadStudentsFromJSON();

        if (studentList == null || studentList.isEmpty()) {
            Log.e("MainActivity", "Student list is null or empty.");
        } else {
            studentAdapter = new StudentAdapter(this, studentList);
            recyclerView.setAdapter(studentAdapter);
        }
    }


    private List<Student> loadStudentsFromJSON() {
        String json = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("data_sv.json")));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            json = builder.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Phân tích JSON thành danh sách sinh viên
        Gson gson = new Gson();
        Type studentListType = new TypeToken<List<Student>>() {}.getType();

        List<Student> students = gson.fromJson(json, studentListType);

        if (students == null) {
            // Nếu students là null, in thông báo để kiểm tra
            Log.e("MainActivity", "Failed to load students from JSON.");
        }

        return students; // Trả về danh sách sinh viên
    }

}
