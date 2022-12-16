package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInAb extends AppCompatActivity {
    EditText username,password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_ab);
        username=(EditText)findViewById(R.id.password_ab_1);
        password=(EditText) findViewById(R.id.password_ab_1);
        btnlogin=(Button)findViewById(R.id.btn_signin_ab_1);
        DB=new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("")||pass.equals("")){

                    Toast.makeText(SignInAb.this,"Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean check_user_password=DB.checkusernamepasswordAB(user,pass);
                    if(check_user_password==true){
                        Toast.makeText(SignInAb.this,"Login successful",Toast.LENGTH_SHORT).show();
                        Intent intent2=new Intent(getApplicationContext(),HomeAbonne.class);
                        startActivity(intent2);
                    }
                    else{
                        Toast.makeText(SignInAb.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}