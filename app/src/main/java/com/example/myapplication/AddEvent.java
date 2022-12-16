package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class AddEvent extends AppCompatActivity {

    EditText title;
    EditText date;
    EditText duree;
    Button add_btn,date_E_btn;

    static final int DATE_ID1=0;
    int year_y1,month_y1,day_y1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        title = findViewById(R.id.title_input);
        duree = findViewById(R.id.duree_input);
        date = findViewById(R.id.date_input);
        add_btn = findViewById(R.id.add_button);
        date_E_btn=(Button)findViewById(R.id.date_event_1);
       calendarDate();
       showDialogOnButtonDateEvent();



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

    public void showDialogOnButtonDateEvent(){
        date_E_btn=(Button) findViewById(R.id.date_event_1);
        date_E_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showDialog(DATE_ID1);

            }
        });
    }

    public DatePickerDialog.OnDateSetListener datePickerListinner=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_y1=year ;
            month_y1=monthOfYear;
            day_y1=dayOfMonth;
            date.setText(day_y1+"/"+month_y1+"/"+year_y1);
        }
    };
public Dialog onCreateDialog(int id,Bundle args){


    if (id==DATE_ID1){
        return  new DatePickerDialog(this,datePickerListinner,year_y1,month_y1,day_y1);

    }
    return null;
}

public void calendarDate(){

    Calendar cal=Calendar.getInstance();
    year_y1=cal.get(Calendar.YEAR) ;
    month_y1=cal.get(Calendar.MONTH);
    day_y1=cal.get(Calendar.DAY_OF_MONTH);

}


}