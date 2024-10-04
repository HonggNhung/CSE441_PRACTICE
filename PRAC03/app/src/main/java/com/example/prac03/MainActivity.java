package com.example.prac03;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private List<CountryItem> conutryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        conutryList = new ArrayList<>();
        // Thêm dữ liệu mô phỏng
        conutryList.add(new CountryItem(
                "2,973,190 KM2",               // Diện tích quốc gia
                "481 people/Km2",              // Mật độ dân số
                "New Delhi",                   // Thủ đô
                R.drawable.india,              // Ảnh đại diện (ảnh drawable của quốc gia)
                "India",                       // Tên quốc gia
                "1,428.6 million people",      // Dân số
                "17.76 %"                      // Tỷ lệ phần trăm dân số toàn cầu
        ));
        conutryList.add(new CountryItem(
                "9,596,961 KM2",               // Diện tích quốc gia
                "153 people/Km2",              // Mật độ dân số
                "Beijing",                     // Thủ đô
                R.drawable.china,              // Ảnh đại diện (ảnh drawable của quốc gia)
                "China",                       // Tên quốc gia
                "1,425.7 million people",      // Dân số
                "17.72 %"                      // Tỷ lệ phần trăm dân số toàn cầu
        ));
        conutryList.add(new CountryItem(
                "9,833,517 KM2",               // Diện tích quốc gia
                "36 people/Km2",               // Mật độ dân số
                "Washington, D.C.",            // Thủ đô
                R.drawable.us,                 // Ảnh đại diện (ảnh drawable của quốc gia)
                "United States",               // Tên quốc gia
                "334.2 million people",        // Dân số
                "4.25 %"                       // Tỷ lệ phần trăm dân số toàn cầu
        ));
        conutryList.add(new CountryItem(
                "377,975 KM2",                 // Diện tích quốc gia
                "340 people/Km2",              // Mật độ dân số
                "Tokyo",                       // Thủ đô
                R.drawable.japan,              // Ảnh đại diện (ảnh drawable của quốc gia)
                "Japan",                       // Tên quốc gia
                "124.8 million people",        // Dân số
                "1.56 %"                       // Tỷ lệ phần trăm dân số toàn cầu
        ));
        conutryList.add(new CountryItem(
                "357,022 KM2",                 // Diện tích quốc gia
                "233 people/Km2",              // Mật độ dân số
                "Berlin",                      // Thủ đô
                R.drawable.germany,            // Ảnh đại diện (ảnh drawable của quốc gia)
                "Germany",                     // Tên quốc gia
                "83.2 million people",         // Dân số
                "1.07 %"                       // Tỷ lệ phần trăm dân số toàn cầu
        ));

        countryAdapter = new CountryAdapter(conutryList, countryItem -> {
            Intent intent = new Intent(MainActivity.this, CountryDetailActivity.class);
            intent.putExtra("name", countryItem.getName());
            intent.putExtra("description", countryItem.getDescription());
            intent.putExtra("image", countryItem.getImageResourceId());
            intent.putExtra("population", countryItem.getPopulation());
            intent.putExtra("area", countryItem.getArea());
            intent.putExtra("worldShare", countryItem.getWorldShare());
            intent.putExtra("density", countryItem.getDensity());
            startActivity(intent);
        });

        recyclerView.setAdapter(countryAdapter);
    }
}
