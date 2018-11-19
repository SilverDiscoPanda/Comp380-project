package com.zane.Comp380_project;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.CalendarView;
import android.widget.Toast;
import android.view.View;
import android.widget.TimePicker;
import android.app.DatePickerDialog;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";

//    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener startDateSetListener;
    private DatePickerDialog.OnDateSetListener endDateSetListener;

    //FragmentManager fragmentManager = getSupportFragmentManager();
    //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //receives intent and displays date
        Intent getevent = getIntent();
        String date = getevent.getStringExtra("date");

        TextView theDate = (TextView) findViewById(R.id.date);
        theDate.setText(date);
        Toast.makeText(getApplicationContext(), "Hello user " + date, Toast.LENGTH_SHORT).show(); //popup


        TimePicker simpleTimePicker = (TimePicker) findViewById(R.id.simpleTimePicker); // initiate a time picker
        simpleTimePicker.setIs24HourView(false);//false for 12 hr clock
        // set the value for current hours
        simpleTimePicker.setHour(8); // from api level 23
        // set the value for current minutes
        simpleTimePicker.setMinute(0); // from api level 23
        // get hour
        int hours = simpleTimePicker.getHour(); // after api level 23
        //get minutes
        int minutes = simpleTimePicker.getMinute(); // after api level 23


        final Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                //initiate a date picker
                DatePicker simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
                simpleDatePicker.setSpinnersShown(false);//false to not show date spinner
                int month = simpleDatePicker.getMonth();
                int year = simpleDatePicker.getYear(); // get the selected year
                int day = simpleDatePicker.getFirstDayOfWeek();


            }
        });




/*
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calendar cal = Calendar.getInstance();
                //int year = cal.get(Calendar.YEAR);
                //int month = cal.get(Calendar.MONTH);
                //int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Main2Activity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }

        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String datepick = month + "/" + day + "/" + year;
                mDisplayDate.setText(datepick);
            }
        };


*/

    }


}
