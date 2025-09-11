package com.example.cmput301lab2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<City> cityAdapter;
    ArrayList<City> dataList;

    int selectedPosition = -1;
    Button addCityBut;
    Button deleteCityBut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cityList = findViewById(R.id.city_list);
        City []cities = {
                new City("Edmonton"),
                new City("Vancouver"),
                new City("Moscow"),
                new City("Sydney"),
                new City("Berlin"),
                new City("Vienna"),
                new City("Tokyo"),
                new City("Beijing"),
                new City("Osaka"),
                new City("New Delhi")
        };
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<City>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    // we get the buttons that are added from the mainactivity first of all





}