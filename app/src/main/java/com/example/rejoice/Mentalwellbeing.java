package com.example.rejoice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mentalwellbeing extends AppCompatActivity implements View.OnClickListener {

    TextView totalquestionstv1;
    TextView questiontv1;
    Button ansmA,ansmB,ansmC,ansmD;
    Button summitbtn1;

    int totalqns1 = Questions.questions1.length;
    int currentqnindex1 = 0;
    int total1=0,scorem1,scorem;
    float lastscore1=0;
    String selectedans1="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentalwellbeing);


        totalquestionstv1 = findViewById(R.id.text_m1);
        questiontv1 = findViewById(R.id.qnsmtv);
        ansmA = findViewById(R.id.ans_ma);
        ansmB = findViewById(R.id.ans_mb);
        ansmC = findViewById(R.id.ans_mc);
        ansmD = findViewById(R.id.ans_md);
        summitbtn1 = findViewById(R.id.btn1);

        ansmA.setOnClickListener(this);
        ansmB.setOnClickListener(this);
        ansmC.setOnClickListener(this);
        ansmD.setOnClickListener(this);
        summitbtn1.setOnClickListener(this);

        totalquestionstv1.setText("Total Questions: "+totalqns1);

        loadNewQuestion1();
    }

    @Override
    public void onClick(View view) {

        ansmA.setBackgroundColor(Color.BLACK);
        ansmB.setBackgroundColor(Color.BLACK);
        ansmC.setBackgroundColor(Color.BLACK);
        ansmD.setBackgroundColor(Color.BLACK);

        Button clickedbutton1 = (Button)  view;

        if (clickedbutton1.getId() == R.id.btn1) {

            scorem1 = calscore1();
            currentqnindex1++;
            loadNewQuestion1();

        } else {
            selectedans1 = clickedbutton1.getText().toString();
            clickedbutton1.setBackgroundColor(Color.RED);

        }
    }

    void loadNewQuestion1(){

        if(currentqnindex1 == totalqns1)
        {
            finishquiz1();
            return;
        }

        questiontv1.setText(Questions.questions1[currentqnindex1]);
        ansmA.setText(Questions.choice1[currentqnindex1][0]);
        ansmB.setText(Questions.choice1[currentqnindex1][1]);
        ansmC.setText(Questions.choice1[currentqnindex1][2]);
        ansmD.setText(Questions.choice1[currentqnindex1][3]);

    }

    void finishquiz1() {
        String passstatus1;
        lastscore1 = scorem1/totalqns1;
        if (lastscore1 >= 90)
            passstatus1 = "Excellent!! You are good with your Mental Health";
        else if (lastscore1 >= 75 && lastscore1 < 90)
            passstatus1 = "Good, Keep improving yourself!";
        else if (lastscore1 >= 50 && lastscore1 < 75)
            passstatus1 = "Average. Try to be optimistic :)";
        else
            passstatus1 = "Acknowledge about it to your parents";


        new AlertDialog.Builder(this)
                .setTitle(passstatus1)
                .setMessage("Your score is "+ lastscore1 +"%"+" out of 100%" )
                .setPositiveButton("Back To Homepage",((dialogInterface, i) -> backhome1()))
                .setNegativeButton("Get some Suggestions",((dialogInterface, i) -> Suggest()))
                .setCancelable(false)
                .show();
    }

    private void Suggest() {
        if(lastscore1>=90)
            gotourl("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2835700/");
        else if(lastscore1>=75 && lastscore1<90)
            gotourl("https://positivepsychology.com/what-is-mental-wellbeing/");
        else if(lastscore1>=50 && lastscore1<75)
            gotourl("https://www.helpguide.org/articles/mental-health/building-better-mental-health.htm");
        else
            gotourl("https://childadolescentpsych.cumc.columbia.edu/articles/11-tips-mental-health-well-being");


    }

    private void gotourl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    void backhome1(){
        Intent intent = new Intent(this,Rejoicepage.class);
        startActivity(intent);

    }

    int calscore1()
    {
        if (selectedans1.equals(Questions.choice1[currentqnindex1][0])) {
            scorem = 10;
            total1 += scorem;
        } else if (selectedans1.equals(Questions.choice1[currentqnindex1][1])) {
            scorem = 100;
            total1 += scorem;
        } else if (selectedans1.equals(Questions.choice1[currentqnindex1][2])) {
            scorem = 50;
            total1 += scorem;
        } else if(selectedans1.equals((Questions.choice1[currentqnindex1][3]))){
            scorem=25;
            total1+=scorem;
        }
        return total1;
    }
}
