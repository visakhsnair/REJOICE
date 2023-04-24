package com.example.rejoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Rejoicepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejoicepage);
    }

    public void btnnext4(View view) {
        Intent intent = new Intent(this,Schooling.class);
        startActivity(intent);
    }

    public void btnnext5(View view) {
        Intent intent = new Intent(this,Mentalwellbeing.class);
        startActivity(intent);
    }

    public void btnnxt6(View view) {
        Intent intent = new Intent(this,OtherActivity.class);
        startActivity(intent);
    }
}