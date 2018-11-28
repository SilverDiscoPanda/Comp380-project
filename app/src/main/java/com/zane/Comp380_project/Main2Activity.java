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
    private TextView theDate;
    private Button startDatebutton;
//private TextView mDisplayDate;

  //  FragmentManager fragmentManager = getSupportFragmentManager();
    // FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //receives intent and displays date
        Intent getevent = getIntent();
        String date = getevent.getStringExtra("date");

        TextView theDate = (TextView) findViewById(R.id.date);
        startDatebutton = (Button) findViewById(R.id.startDatebutton);
        theDate.setText(date);
        Toast.makeText(getApplicationContext(), "Hello user " + date, Toast.LENGTH_SHORT).show();//popup


        startDatebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent startDateEvent = new Intent(Main2Activity.this,DatePickActivity.class);
                startActivity(startDateEvent);


            }
        });


    }


}
