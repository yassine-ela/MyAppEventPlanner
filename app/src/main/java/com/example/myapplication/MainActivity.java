package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button btn1;
   private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=this.findViewById(R.id.btn_ab);
        btn2=this.findViewById(R.id.btn_ad);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent1=new Intent(getApplicationContext(),SignUpAb.class);
                startActivity(myIntent1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent2=new Intent(getApplicationContext(),SignInAd.class);
                startActivity(myIntent2);
            }
        });
    }
}