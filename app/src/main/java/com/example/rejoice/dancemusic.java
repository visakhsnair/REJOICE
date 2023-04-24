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

public class dancemusic extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnn2,btnn3;
    String state1;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dancemusic);

        btnn2 = findViewById(R.id.btn2);
        btnn3 = findViewById(R.id.btn3);

        Spinner spinner = findViewById(R.id.spin2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dance, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state1 = spinner.getSelectedItem().toString();
                danceandmusic1();
            }


            private void danceandmusic1() {
                if (state1.equals("Bharatanatyam"))
                    gotourl2("https://narthaki.com/info/articles/article35.html");
                else if (state1.equals("Folk dance"))
                    gotourl2("https://www.britannica.com/art/folk-dance");
                else if (state1.equals("Contemporary"))
                    gotourl2("https://www.masterclass.com/articles/what-is-contemporary-dance#what-is-contemporary-dance");
                else if (state1.equals("Kathakali"))
                    gotourl2("https://thedanceindia.com/article-kathakali/");
                else if (state1.equals("Hip Hop"))
                    gotourl2("https://www.steezy.co/posts/what-is-hip-hop-dance");
                else if (state1.equals("Carnatic Music"))
                    gotourl2("https://www.newworldencyclopedia.org/entry/carnatic_music");
                else if (state1.equals("Pop Music"))
                    gotourl2("https://www.udiscovermusic.com/in-depth-features/pop-the-worlds-most-important-art-form/");
                else if (state1.equals("Folk Music"))
                    gotourl2("https://www.britannica.com/art/folk-music");
                else if (state1.equals("Ballet"))
                    gotourl2("https://www.britannica.com/art/ballet");
                else
                    gotourl2("https://www.encyclopedia.com/international/encyclopedias-almanacs-transcripts-and-maps/music-and-dance");
            }
        });

        btnn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state1 = spinner.getSelectedItem().toString();
                danceandmusic2();
            }
            private void danceandmusic2() {
                if (state1.equals("Bharatanatyam"))
                    gotourl2("https://www.ipassio.com/online-bharatanatyam-classes");
                else if (state1.equals("Folk dance"))
                    gotourl2("https://www.kadaiveedhi.shop/product/folk-dance-classes");
                else if (state1.equals("Contemporary"))
                    gotourl2("https://www.youtube.com/watch?v=yGycDrVuD50");
                else if (state1.equals("Kathakali"))
                    gotourl2("https://danceclassonline.in/Kathakali-dance-Lessons-school-online-dancing-classes.php");
                else if (state1.equals("Hip Hop"))
                    gotourl2("https://www.dancewithmadhuri.com/learn.php?danceStyle=Street+Dancing&utm_source=Google_Search&utm_medium=Dancewise_StreetDancing&utm_campaign=Dancewise&gclid=CjwKCAjwve2TBhByEiwAaktM1EdECSVXhpxkO1R5mCvm4AzfQ97ntbfLdbIr9p6QdQHenShrXKD9LRoCujgQAvD_BwE");
                else if (state1.equals("Carnatic Music"))
                    gotourl2("https://artiumacademy.com/web/registration?utm_source=GOOGLE&utm_medium=SEARCH&utm_campaign=SOUTHREGION&gclid=CjwKCAjwve2TBhByEiwAaktM1HbMx9uQp4v-x1g9sqdwU_V6_DvYG654ulfnSfylC88MoDlNjjp-GBoCiRkQAvD_BwE");
                else if (state1.equals("Pop Music"))
                    gotourl2("https://www.pointblankmusicschool.com/courses/online/degree-and-he-programmes/ba-hons-music-industry-management-degree-online/?gclid=CjwKCAjwve2TBhByEiwAaktM1EyBmFuwdqcKJnlRvXYoG1sxUjCzeRCc2iF-8Xhm-MM8l3aXMAw8dRoCz0cQAvD_BwE");
                else if (state1.equals("Folk Music"))
                    gotourl2("https://www.shankarmahadevanacademy.com/courses-overview/?gclid=CjwKCAjwve2TBhByEiwAaktM1LRQGzDNM-_NxO1pfkPdkcXgM80MsgbCIYn312EeTP7_lfDe65Gs8BoCJHYQAvD_BwE");
                else if (state1.equals("Ballet"))
                    gotourl2("https://www.udemy.com/topic/ballet/");
                else
                    gotourl2("https://kafqa.com/");
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

    private void gotourl2(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}