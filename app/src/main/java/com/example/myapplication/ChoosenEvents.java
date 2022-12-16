package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChoosenEvents extends AppCompatActivity {
    RecyclerView recyclerView2;

    ImageView empty_imageview2;
    TextView no_data2;
    MyDatabaseHelper myDB2;
    ArrayList<String> event_id2, event_title2, event_date2, event_duree2;
    CustomAdapterAb customAdapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosen_events);
        recyclerView2= findViewById(R.id.recyclerView2);
        empty_imageview2 =findViewById(R.id.empty_imageView2);
        no_data2 = findViewById(R.id.no_data2);
        myDB2 = new MyDatabaseHelper(ChoosenEvents.this);
        event_id2 = new ArrayList<>();
        event_title2= new ArrayList<>();
        event_date2= new ArrayList<>();
        event_duree2= new ArrayList<>();
        storeDataInArrays2();
        customAdapter3 = new CustomAdapterAb(ChoosenEvents.this,this,event_id2, event_title2,event_date2,event_duree2);
        recyclerView2.setAdapter(customAdapter3);
        recyclerView2.setLayoutManager(new LinearLayoutManager(ChoosenEvents.this));

    }


    private void storeDataInArrays2() {
        Cursor cursor = myDB2.readAllData2();
        if(cursor.getCount() == 0){
            empty_imageview2.setVisibility(View.VISIBLE);
            no_data2.setVisibility(View.VISIBLE);
        }else {
            while (cursor.moveToNext()){
                event_id2.add(cursor.getString(0));
                event_title2.add(cursor.getString(1));
                event_date2.add(cursor.getString(2));
                event_duree2.add(cursor.getString(3));
            }
            empty_imageview2.setVisibility(View.GONE);
            no_data2.setVisibility(View.GONE);


        }}

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.my_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }
    }

