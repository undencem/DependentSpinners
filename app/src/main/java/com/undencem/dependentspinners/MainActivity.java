package com.undencem.dependentspinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1, spinner2;
    List<String> subCategories = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner_1);
        spinner2 = findViewById(R.id.spinner_2);

        List<String> categories = new ArrayList<>();
        categories.add("Pen");
        categories.add("Marker");
        categories.add("Register");
        categories.add("Pencil");

        ArrayAdapter<String> adapter_1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories);
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter_1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Register")){
                    subCategories.clear();
                    subCategories.add("Company");
                    subCategories.add("Pages");
                    subCategories.add("Deneme");
                    subCategories.add("Deneme 2");
                    fillSpinner();
                }else if(parent.getItemAtPosition(position).equals("Pen")){
                    subCategories.clear();
                    subCategories.add("Brand");
                    subCategories.add("Quantity");
                    fillSpinner();
                }else if(parent.getItemAtPosition(position).equals("Marker")){
                    subCategories.clear();
                    subCategories.add("1");
                    subCategories.add("2");
                    fillSpinner();
                }else if(parent.getItemAtPosition(position).equals("Pencil")){
                    subCategories.clear();
                    subCategories.add("3");
                    subCategories.add("4");
                    fillSpinner();
                }else {
                    subCategories.clear();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                subCategories.clear();
            }
        });

    }

    public void fillSpinner(){
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,subCategories);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
    }

}