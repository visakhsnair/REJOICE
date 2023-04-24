package com.example.rejoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }

    public void btnnext6(View view) {
        Intent intent = new Intent(this,sports.class);
        startActivity(intent);
    }

    public void btnnext7(View view) {
        Intent intent = new Intent(this,dancemusic.class);
        startActivity(intent);
    }

    public void btnnxt8(View view) {
        Intent intent = new Intent(this,personalitydevelopment.class);
        startActivity(intent);
    }

}