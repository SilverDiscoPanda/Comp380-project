package com.zane.Comp380_project;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.CalendarView;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements
View.OnClickListener {

    Button startDatebutton, endDatebutton,startTimebutton,endTimebutton,savebutton;
    EditText sDate, txtTime;
    private TextView theDate;
    private int sYear, sMonth, sDay,eYear,eMonth,eDay, sHour, sMinute,eHour,eMinute;
    private String Clockformat = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent getevent = getIntent();
        String date = getevent.getStringExtra("date");
        TextView theDate = (TextView) findViewById(R.id.date);

       // txtDate=(EditText)findViewById(R.id.in_date);
       // txtTime=(EditText)findViewById(R.id.in_time);

        startDatebutton = (Button) findViewById(R.id.startDatebutton);
        endDatebutton = (Button) findViewById(R.id.endDatebutton);
        startTimebutton = (Button) findViewById(R.id.startTimebutton);
        endTimebutton = (Button) findViewById(R.id.endTimebutton);
        savebutton = (Button) findViewById(R.id.savebutton);

        startDatebutton.setOnClickListener(this);
        endDatebutton.setOnClickListener(this);
        startTimebutton.setOnClickListener(this);
        endTimebutton.setOnClickListener(this);
        savebutton.setOnClickListener(this);

        theDate.setText(date);
        startDatebutton.setText(date);
        endDatebutton.setText(date);


        Toast.makeText(getApplicationContext(), "Hello user " + date, Toast.LENGTH_SHORT).show();//popup
    }

    @Override
    public void onClick(View v) {

        if (v == startDatebutton) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            sYear = c.get(Calendar.YEAR);
            sMonth = c.get(Calendar.MONTH);
            sDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            startDatebutton.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                           //startDatebutton.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, sYear, sMonth, sDay);
            datePickerDialog.show();
        }

        if (v == endDatebutton) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            eYear = c.get(Calendar.YEAR);
            eMonth = c.get(Calendar.MONTH);
            eDay = c.get(Calendar.DAY_OF_MONTH);


            final DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            endDatebutton.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                           // endDatebutton.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, eYear, eMonth, eDay);

            datePickerDialog.show();
            ;
        }
        if (v == startTimebutton) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            sHour = c.get(Calendar.HOUR_OF_DAY);
            sMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            final TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            sTimeDisplay(hourOfDay, minute);
                            //startTimebutton.setText(hourOfDay + ":" + minute);
                        }
                    }, sHour, sMinute, false);
            timePickerDialog.show();


        }


        if (v == endTimebutton) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            eHour = c.get(Calendar.HOUR_OF_DAY);
            eMinute = c.get(Calendar.MINUTE);

            //android.R.style.Theme_Holo_Light_Dialog_NoActionBar,  /////after this, for digital clock
            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                               eTimeDisplay(hourOfDay, minute);
                       //     startTimebutton.setText(hourOfDay + ":" + minute);
                        }
                    }, eHour, eMinute, false);
            timePickerDialog.show();
        }
        if (v == savebutton) {
            Intent saveIntent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(saveIntent);
            Toast.makeText(getApplicationContext(), "Event Saved" , Toast.LENGTH_SHORT).show();//popup
        }
    }


    private void sTimeDisplay(int hourOfDay, int minute) {
        if (hourOfDay == 0) {
            hourOfDay += 12;
            Clockformat = "AM";
        } else if (hourOfDay == 12) {
            Clockformat = "PM";
        } else if (hourOfDay > 12) {
            hourOfDay -= 12;
            Clockformat = "PM";
        } else {
            Clockformat = "AM";
        }

        startTimebutton.setText(
                new StringBuilder()
                        .append(pad(hourOfDay)).append(":")
                        .append(pad(minute)).append(" ").append(Clockformat));
    }


    private void eTimeDisplay(int hourOfDay, int minute) {
        if (hourOfDay == 0) {
            hourOfDay += 12;
            Clockformat = "AM";
        } else if (hourOfDay == 12) {
            Clockformat = "PM";
        } else if (hourOfDay > 12) {
            hourOfDay -= 12;
            Clockformat = "PM";
        } else {
            Clockformat = "AM";
        }

        endTimebutton.setText(
                new StringBuilder()
                        .append(pad(hourOfDay)).append(":")
                        .append(pad(minute)).append(" ").append(Clockformat));
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}



