package com.zane.Comp380_project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.time.Clock;
import java.util.Calendar;

public class DatePickActivity extends AppCompatActivity {

    private TextView sDate;
    private TextView sTime;
    private String Clockformat = "";
    private int sYear;
    private int sMonth;
    private int sDay;
    private DatePicker.OnDateChangedListener sDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pick);

        //initiate a date picker
        DatePicker simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
        sDate = (TextView) findViewById(R.id.sDateDisplay);




        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        calendar.setTimeInMillis(System.currentTimeMillis());
        sDateDisplay();
        simpleDatePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                sYear = year;
                sMonth = month;
                sDay = dayOfMonth;
                sDateDisplay();
            }
        });


        TimePicker simpleTimePicker = (TimePicker) findViewById(R.id.simpleTimePicker); // initiate a time picker

        simpleTimePicker.setIs24HourView(false);//false for 12 hr clock
        simpleTimePicker.setHour(8); // from api level 23
        simpleTimePicker.setMinute(0); // from api level 23

        sTime = (TextView) findViewById(R.id.sTimeDisplay);

        sTimeDisplay(8, 0);

        simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                sTimeDisplay(hourOfDay, minute);
            }
        });

    }

    private void sDateDisplay() {
        sDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(sMonth + 1).append("-")
                        .append(sDay).append("-")
                        .append(sYear).append(" "));
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

        sTime.setText(
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
