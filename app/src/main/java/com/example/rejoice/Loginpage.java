package com.example.rejoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage extends AppCompatActivity {

    EditText username, password, email;
    Button login, hnregister;
    DBhelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        login = (Button) findViewById(R.id.button2);
        hnregister = (Button) findViewById(R.id.button3);
        DB = new DBhelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String mail = email.getText().toString();

                if(user.equals("")||pass.equals("")||mail.equals(""))
                    Toast.makeText(Loginpage.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpassmail = DB.checkall(user,pass,mail);
                    if(checkuserpassmail==true){
                        Toast.makeText(Loginpage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Rejoicepage.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Loginpage.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        hnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Registerpage.class);
                startActivity(intent);
            }
        });
    }
}