package com.example.rejoice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class personalitydevelopment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnn4,btnn5;
    String state2;
    @SuppressLint("CutPasteId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalitydevelopment);

        btnn4 = findViewById(R.id.btn4);
        btnn5 = findViewById(R.id.btn5);

        Spinner spinner = findViewById(R.id.spin3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.pd, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state2 = spinner.getSelectedItem().toString();
                pd12();
            }


            private void pd12() {
                if (state2.equals("Extrovert"))
                    gotourl3("https://www.youtube.com/watch?v=v2euEwGnas8");
                else if (state2.equals("Introvert"))
                    gotourl3("https://www.youtube.com/watch?v=nCmCZO37JYY");
                else if (state2.equals("Ambivert"))
                    gotourl3("https://www.youtube.com/watch?v=l_-oBnK12-4");
                else if (state2.equals("Omnivert"))
                    gotourl3("https://www.youtube.com/watch?v=Ys-7gKhk-_o");
            }
        });

        btnn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state2 = spinner.getSelectedItem().toString();
                pd13();
            }
            private void pd13() {
                if (state2.equals("Extrovert"))
                    gotourl3("https://www.developgoodhabits.com/personal-development-books/");
                else if (state2.equals("Introvert"))
                    gotourl3("https://shedreamsallday.com/the-best-personal-development-books-for-introverts/");
                else if (state2.equals("Ambivert"))
                    gotourl3("https://www.wallstreetmojo.com/personality-development-books/");
                else if (state2.equals("Omnivert"))
                    gotourl3("https://www.lifehack.org/articles/lifestyle/the-25-best-self-improvement-books-read-before-you-turn-25.html");
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void gotourl3(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}