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
        String tortName = intent.getStringExtra("tortName");
        String tortTaste_rating = intent.getStringExtra("tortTaste_rating");
        String tortPrice = intent.getStringExtra("tortPrice");
        String tortWeight = intent.getStringExtra("tortWeight");

        foodName.setText(tortName+" "+tortTaste_rating+" "+ tortPrice+" "+tortWeight);
    }
}
