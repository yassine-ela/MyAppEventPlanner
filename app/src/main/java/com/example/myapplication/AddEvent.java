package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEvent extends AppCompatActivity {

    EditText title;
    EditText date;
    EditText duree;
    Button add_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        title = findViewById(R.id.title_input);
        duree = findViewById(R.id.duree_input);
        date = findViewById(R.id.date_input);
        add_btn = findViewById(R.id.add_button);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddEvent.this);
                myDB.addEvent1(title.getText().toString().trim(),
                        duree.getText().toString().trim(),
                        date.getText().toString().trim());
            }
        });

    }
}