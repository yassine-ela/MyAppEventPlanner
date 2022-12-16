package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInAd extends AppCompatActivity {
    EditText username, password;
    Button btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_ad);
        username = (EditText) findViewById(R.id.username_ad_1);
        password = (EditText) findViewById(R.id.password_ad_1);
        btn = (Button) findViewById(R.id.btn_signIn_ad_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
               if (user.equals("")||pass.equals("")){

                   Toast.makeText(SignInAd.this,"please enter all fields",Toast.LENGTH_SHORT).show();
               }
                 else{

                     if(user.equals("admin")&&pass.equals("admin")){
                         Toast.makeText(SignInAd.this,"Login Successful",Toast.LENGTH_SHORT).show();
                         Intent intent2=new Intent(getApplicationContext(),HomeAdmin.class);
                         startActivity(intent2);
                     }
                     else {
                         Toast.makeText(SignInAd.this,"Login Failed",Toast.LENGTH_SHORT).show();
                     }

               }
            }
        });
    }
}
