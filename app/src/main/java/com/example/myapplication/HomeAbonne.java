package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class HomeAbonne extends AppCompatActivity {
    RecyclerView recyclerView1;

    ImageView empty_imageview1;
    TextView no_data1;
    Button btn;




    MyDatabaseHelper myDB1;
    ArrayList<String> event_id1, event_title1, event_date1, event_duree1 ;
    CustomAdapterAbonne customAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_abonne);
        btn=findViewById(R.id.btn_ev_choisi);
        recyclerView1 = findViewById(R.id.recyclerView1);
        empty_imageview1 =findViewById(R.id.empty_imageView1);
        no_data1 = findViewById(R.id.no_data1);

        myDB1 = new MyDatabaseHelper(HomeAbonne.this);
        event_id1 = new ArrayList<>();
        event_title1 = new ArrayList<>();
        event_date1 = new ArrayList<>();
        event_duree1 = new ArrayList<>();
        storeDataInArrays1();

        customAdapter1 = new CustomAdapterAbonne(HomeAbonne.this,this,event_id1,event_title1,event_date1,event_duree1);
        recyclerView1.setAdapter(customAdapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(HomeAbonne.this));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent1=new Intent(getApplicationContext(),ChoosenEvents.class);
                startActivity(myIntent1);
            }
        });

    }



    private void storeDataInArrays1() {
        Cursor cursor = myDB1.readAllData1();
        if(cursor.getCount() == 0){
            empty_imageview1.setVisibility(View.VISIBLE);
            no_data1.setVisibility(View.VISIBLE);
        }else {
            while (cursor.moveToNext()){
                event_id1.add(cursor.getString(0));
                event_title1.add(cursor.getString(1));
                event_date1.add(cursor.getString(2));
                event_duree1.add(cursor.getString(3));
            }
            empty_imageview1.setVisibility(View.GONE);
            no_data1.setVisibility(View.GONE);


            }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    }
