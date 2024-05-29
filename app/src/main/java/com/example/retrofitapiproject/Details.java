package com.example.retrofitapiproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Details extends AppCompatActivity {

    ImageView im;
    TextView txtteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        im = findViewById(R.id.img);
        txtteam = findViewById(R.id.teamnaem);

        Intent intent = getIntent();
        String TeamBadge = intent.getStringExtra("teamBadge");
        String TeamName = intent.getStringExtra("teamName");

        Glide.with(this).load(TeamBadge).into(im);
        txtteam.setText(TeamName);
    }
}