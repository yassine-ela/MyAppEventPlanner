package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpAb extends AppCompatActivity {

    EditText username, password, repassword, cin;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_ab);
        cin = (EditText) findViewById(R.id.cin_ab);
        username = (EditText) findViewById(R.id.username_ab);
        password = (EditText) findViewById(R.id.password_ab);
        repassword = (EditText) findViewById(R.id.repass_ab);
        signup = (Button) findViewById(R.id.btn_signup_ab);
        signin = (Button) findViewById(R.id.btn_signIn_ab);
        DB = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ci=cin.getText().toString();
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();
                if (user.equals("") ||ci.equals("")|| pass.equals("")  || repass.equals(""))

                    Toast.makeText(SignUpAb.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusernameAB(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertDataAB(ci,user, pass);
                            if (insert == true) {
                                Toast.makeText(SignUpAb.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),SignInAb.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(SignUpAb.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            Toast.makeText(SignUpAb.this, "user already exists", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(SignUpAb.this, "paswords not matching", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });
      signin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent1 = new Intent(getApplicationContext(),SignInAb.class);
              startActivity(intent1);
          }
      });

    }
}