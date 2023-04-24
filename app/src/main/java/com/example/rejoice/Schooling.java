package com.example.rejoice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Schooling extends AppCompatActivity implements View.OnClickListener{

    TextView totalquestionstv;
    TextView questiontv;
    Button ansA,ansB,ansC,ansD;
    Button summitbtn;

    int totalqns = Questions.questions.length;
    int currentqnindex = 0;
    int total=0,score1,score;
    float lastscore=0;
    String selectedans="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schooling);

        totalquestionstv = findViewById(R.id.text_1);
        questiontv = findViewById(R.id.qnstv);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        summitbtn = findViewById(R.id.btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        summitbtn.setOnClickListener(this);

        totalquestionstv.setText("Total Questions: "+totalqns);

        loadNewQuestion();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.BLACK);
        ansB.setBackgroundColor(Color.BLACK);
        ansC.setBackgroundColor(Color.BLACK);
        ansD.setBackgroundColor(Color.BLACK);

        Button clickedbutton = (Button)  view;

            if (clickedbutton.getId() == R.id.btn) {

                score1 = calscore();
                currentqnindex++;
                loadNewQuestion();

            } else {
                selectedans = clickedbutton.getText().toString();
                clickedbutton.setBackgroundColor(Color.RED);

            }
    }

    void loadNewQuestion(){

        if(currentqnindex == totalqns)
        {
            finishquiz();
            return;
        }

        questiontv.setText(Questions.questions[currentqnindex]);
        ansA.setText(Questions.choice[currentqnindex][0]);
        ansB.setText(Questions.choice[currentqnindex][1]);
        ansC.setText(Questions.choice[currentqnindex][2]);
        ansD.setText(Questions.choice[currentqnindex][3]);

    }

    void finishquiz() {
        String passstatus;
        lastscore = score1/totalqns;
        if (lastscore >= 90)
            passstatus = "Excellent!! You are building your carrier in a good school";
        else if (lastscore >= 75 && lastscore < 90)
            passstatus = "Good, Keep working to build your carrier";
        else if (lastscore >= 50 && lastscore < 75)
            passstatus = "Average. Try to be active in your school";
        else
            passstatus = "Acknowledge about it to your parents";


        new AlertDialog.Builder(this)
                .setTitle(passstatus)
                .setMessage("Your score is "+ lastscore +"%"+" out of 100%" )
                .setPositiveButton("Back To Homepage",((dialogInterface, i) -> backhome()))
                .setNegativeButton("Get some Suggestions",((dialogInterface, i) -> Suggest1()))
                .setCancelable(false)
                .show();
    }

    private void Suggest1() {
        if(lastscore>=90)
            gotourl1("https://greatperformersacademy.com/motivation/self-improvement-strategy-for-students-success");
        else if(lastscore>=75 && lastscore<90)
            gotourl1("https://www.emeraldgrouppublishing.com/archived/learning/study_skills/life/index.htm");
        else if(lastscore>=50 && lastscore<75)
            gotourl1("https://www.frontiersin.org/articles/10.3389/fpsyg.2019.01730/full");
        else
            gotourl1("https://www.indiastudychannel.com/resources/142503-Duties-Good-student.aspx#:~:text=Student%20must%20be%20punctual%20and,and%20reverence%20to%20his%20teachers.");
    }

    private void gotourl1(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    void backhome(){
        Intent intent = new Intent(this,Rejoicepage.class);
        startActivity(intent);

    }

    int calscore()
    {
        if (selectedans.equals(Questions.choice[currentqnindex][0])) {
            score = 50;
            total += score;
        } else if (selectedans.equals(Questions.choice[currentqnindex][1])) {
            score = 25;
            total += score;
        } else if (selectedans.equals(Questions.choice[currentqnindex][2])) {
            score = 10;
            total += score;
        } else if(selectedans.equals((Questions.choice[currentqnindex][3]))){
            score=100;
            total+=score;
        }
        return total;
    }
}