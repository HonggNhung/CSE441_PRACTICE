package com.example.usingrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Landmark> landmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Khoi tao danh sach
        landmarks = new ArrayList<Landmark>();
        landmarks.add(new Landmark(R.drawable.eiffel_tower,"Tháp Eiffel"));
        landmarks.add(new Landmark(R.drawable.buckingham_palace, "Cung điện Buckingham"));
        landmarks.add(new Landmark(R.drawable.statue_of_liberty, "Tượng Nữ thần Tự do"));
    }
}