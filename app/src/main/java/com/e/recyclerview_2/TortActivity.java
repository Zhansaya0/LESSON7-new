package com.e.recyclerview_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TortActivity extends AppCompatActivity {
    TextView foodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tort);
        foodName = findViewById(R.id.tortName);

        Intent intent = getIntent();
        String tName = intent.getStringExtra("foodName");
        String foodTaste_rating = intent.getStringExtra("foodTaste_rating");
        String foodPrice = intent.getStringExtra("foodPrice");

        foodName.setText(tName+" "+foodTaste_rating+" "+ foodPrice);
    }
}
