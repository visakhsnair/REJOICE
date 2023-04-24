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

public class sports extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnn,btnn1;
    String state;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        btnn = findViewById(R.id.btn2);
        btnn1 = findViewById(R.id.btn3);

        Spinner spinner = findViewById(R.id.spin1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.games, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = spinner.getSelectedItem().toString();
                games1();
            }


            private void games1() {
                if (state.equals("Cricket"))
                    gotourl1("https://cricblog.net/five-ways-improve-cricket-player/");
                else if (state.equals("Football"))
                    gotourl1("https://thepfsa.co.uk/how-to-get-better-at-football/");
                else if (state.equals("Basketball"))
                    gotourl1("https://www.masterclass.com/articles/how-to-improve-your-basketball-skills");
                else if (state.equals("Kabaddi"))
                    gotourl1("https://www.tutorialspoint.com/kabaddi/kabaddi_game_tactics.htm");
                else if (state.equals("Badminton"))
                    gotourl1("https://www.sportswebsites.org/how-to-improve-your-badminton-skill-and-techniques/");
                else if (state.equals("Hockey"))
                    gotourl1("https://hockeytraining.com/increase-performance/");
                else if (state.equals("Boxing"))
                    gotourl1("https://www.titleboxing.com/news/seven-things-you-can-do-to-improve-your-technique");
                else if (state.equals("Chess"))
                    gotourl1("https://scoutlife.org/hobbies-projects/funstuff/152114/improve-your-chess-skills-with-these-9-expert-tips/");
                else if (state.equals("Tennis"))
                    gotourl1("https://eliteclubs.com/ten-quick-tips-to-improve-your-tennis-game/");
                else
                    gotourl1("https://blog.pitchero.com/9-simple-steps-to-becoming-a-better-sports-player");
            }
        });

        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = spinner.getSelectedItem().toString();
                games2();
            }
            private void games2() {
                if (state.equals("Cricket"))
                    gotourl1("https://www.youtube.com/watch?v=I4G9oJD1e4U");
                else if (state.equals("Football"))
                    gotourl1("https://www.youtube.com/watch?v=H5SMtN6Qa6w");
                else if (state.equals("Basketball"))
                    gotourl1("https://www.youtube.com/watch?v=foxgBVF3LwM");
                else if (state.equals("Kabaddi"))
                    gotourl1("https://www.youtube.com/watch?v=3eZf4q6Gb-I");
                else if (state.equals("Badminton"))
                    gotourl1("https://www.youtube.com/watch?v=92gCzJBNLcI");
                else if (state.equals("Hockey"))
                    gotourl1("https://www.youtube.com/watch?v=FyZNsBwfjqQ");
                else if (state.equals("Boxing"))
                    gotourl1("https://www.youtube.com/watch?v=kKDHdsVN0b8");
                else if (state.equals("Chess"))
                    gotourl1("https://www.youtube.com/watch?v=MA8Scue28Ks");
                else if (state.equals("Tennis"))
                    gotourl1("https://www.youtube.com/watch?v=YqgcykDGB2A");
                else
                    gotourl1("https://www.youtube.com/watch?v=sDsuW9RaQK0");
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
    private void gotourl1(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}