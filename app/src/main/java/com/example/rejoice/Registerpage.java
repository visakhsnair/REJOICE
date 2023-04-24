package com.example.rejoice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Registerpage extends AppCompatActivity {

    EditText name,standard,dob,address,phno,username,password,email;
    Button registerbtn;
    DBhelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        dob = (EditText) findViewById(R.id.dob_et);
        name = (EditText) findViewById(R.id.name_et);
        standard = (EditText) findViewById(R.id.Std_et);
        address = (EditText) findViewById(R.id.Add_et);
        phno = (EditText) findViewById(R.id.no_et);
        username = (EditText) findViewById(R.id.user_et);
        password = (EditText) findViewById(R.id.pass_et);
        email = (EditText) findViewById(R.id.mail_et);
        registerbtn = (Button) findViewById(R.id.button4);
        DB = new DBhelper(this);

         registerbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String user = username.getText().toString();
                 String pass = password.getText().toString();
                 String mail = email.getText().toString();

                 if(user.equals("") || pass.equals("") || mail.equals(""))
                     Toast.makeText(Registerpage.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                 else {
                     Boolean checkuser = DB.checkusername(user);
                     Boolean checkmail = DB.checkemail(mail);
                     if (checkuser == false && checkmail == false) {
                         Boolean insert = DB.insertdata(user, pass, mail);
                         if(insert==true){
                             Toast.makeText(Registerpage.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(getApplicationContext(),Loginpage.class);
                             startActivity(intent);
                         }
                         else {
                             Toast.makeText(Registerpage.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                         }
                     }
                     else{
                         Toast.makeText(Registerpage.this, "User Already Exists. Kindly Register!", Toast.LENGTH_SHORT).show();
                     }
                 }

             }
         });
    }


}