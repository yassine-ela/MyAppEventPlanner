package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChoosenEv extends AppCompatActivity {
    EditText title_input, date_input, duree_input;
    Button choose_button;

    String id, title, date, duree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosen_ev);

        title_input = findViewById(R.id.title_input3);
        date_input = findViewById(R.id.date_input3);
        duree_input = findViewById(R.id.duree_input3);
        choose_button = findViewById(R.id.chooseButton);
        getAndSetIntentData2();
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(title);
        }

        choose_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(ChoosenEv.this);

                title=title_input.getText().toString().trim();
                date=date_input.getText().toString().trim();
                duree=duree_input.getText().toString().trim();
                myDB.addEvent2(title, date, duree);
            }
        });



    }
    void getAndSetIntentData2(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("date") && getIntent().hasExtra("duree")){
            //Getting data from intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            date = getIntent().getStringExtra("date");
            duree = getIntent().getStringExtra("duree");

            //Setting intent data

            title_input.setText(title);
            date_input.setText(date);
            duree_input.setText(duree);
        }else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}