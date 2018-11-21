package com.zane.Comp380_project;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class DatePickActivity extends AppCompatActivity {

    private DatePicker.OnDateChangedListener sDateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pick);


/*
        //initiate a date picker
        DatePicker simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
      //  simpleDatePicker.setSpinnersShown(false);//false to not show date spinner
        int month = simpleDatePicker.getMonth();
        int year = simpleDatePicker.getYear();
        int day = simpleDatePicker.getDayOfMonth();
*/




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


    sDateSetListener = new DatePicker.OnDateChangedListener() {


        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
            String startDate = "";

        }

    };

/*
public void setDate(){

            DatePicker simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            simpleDatePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                @Override
                public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                    Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);

                    String startDate = "";

                }
            });


        }

*/

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
