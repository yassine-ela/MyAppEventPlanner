package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEvent extends AppCompatActivity {

    EditText title_input, date_input, duree_input;
    Button update_button, delete_button;

    String id, title, date, duree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_event);

        title_input = findViewById(R.id.title_input2);
        date_input = findViewById(R.id.date_input2);
        duree_input = findViewById(R.id.duree_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData1();
        //set actionbar title after getAndSetIntent Data method
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(title);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateEvent.this);
                title=title_input.getText().toString().trim();
                date=date_input.getText().toString().trim();
                duree=duree_input.getText().toString().trim();
                myDB.updateData1(id, title, date, duree);

            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });


    }

    void getAndSetIntentData1(){
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

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + "?");
        builder.setMessage("Are you sure you want to delete " + title + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateEvent.this);
                myDB.deleteOneRow1(id);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}