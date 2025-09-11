package com.example.cmput301lab2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    Button but_add_city;
    Button delete_button;

    Button confirm_button;

    EditText edit_name_city;
    View add_panel;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cityList = findViewById(R.id.city_list);
        but_add_city= findViewById(R.id.but_add_city);
        delete_button= findViewById(R.id.delete_button);
        add_panel=findViewById(R.id.add_panel);
        edit_name_city=findViewById(R.id.edit_city_name);


        confirm_button=findViewById(R.id.confirm_button);




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

        //picks the selected row and highlights it and holds the index of that row, so we can keep

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                cityList.setItemChecked(position,true);
            }

        });
// shows the thing at the bottom where we can actually write new city
        but_add_city.setOnClickListener(v -> {
            add_panel.setVisibility(View.VISIBLE);
            edit_name_city.setText("");
            edit_name_city.requestFocus();


        });
        confirm_button.setOnClickListener(v -> {
            String name = edit_name_city.getText().toString().trim();
            if (name.isEmpty()) {
                edit_name_city.setError("Enter city name");
                return;

            }
            dataList.add(new City(name));
            cityAdapter.notifyDataSetChanged();

            add_panel
        });
    }

    // we get the buttons that are added from the mainactivity first of all





}