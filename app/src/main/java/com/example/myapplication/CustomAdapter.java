package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList event_id, event_title, event_date, event_duree;


    CustomAdapter(Activity activity, Context context , ArrayList event_id, ArrayList event_title, ArrayList event_date, ArrayList event_duree){
        this.activity = activity;
        this.context = context;
        this.event_id = event_id;
        this.event_title = event_title;
        this.event_date  = event_date;
        this.event_duree  = event_duree;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {


        holder.event_id_txt.setText(String.valueOf(event_id.get(position)));
        holder.event_title_txt.setText(String.valueOf(event_title.get(position)));
        holder.event_date_txt.setText(String.valueOf(event_date.get(position)));
        holder.event_duree_txt.setText(String.valueOf(event_duree.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(context, UpdateEvent.class );
                intent.putExtra("id", String.valueOf(event_id.get(position)));
                intent.putExtra("title", String.valueOf(event_title.get(position)));
                intent.putExtra("date", String.valueOf(event_date.get(position)));
                intent.putExtra("duree", String.valueOf(event_duree.get(position)));




                activity.startActivityForResult(intent, 1);

            }

        });


    }

    @Override
    public int getItemCount() {
        return event_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView event_id_txt, event_title_txt, event_date_txt, event_duree_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            event_id_txt = itemView.findViewById(R.id.event_id_text);
            event_title_txt = itemView.findViewById(R.id.event_title_text);
            event_date_txt = itemView.findViewById(R.id.event_date_text);
            event_duree_txt = itemView.findViewById(R.id.event_duree_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
