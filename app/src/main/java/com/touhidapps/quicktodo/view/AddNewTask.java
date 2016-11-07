package com.touhidapps.quicktodo.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.commonitems.DateTimePicker;

import java.util.Calendar;
import java.util.Date;

public class AddNewTask extends AppCompatActivity {

    DateTimePicker custom;
    EditText editText_dueDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        editText_dueDate = (EditText)findViewById(R.id.editText_dueDate);

        custom = new DateTimePicker(this,
                new DateTimePicker.ICustomDateTimeListener() {

                    @Override
                    public void onSet(Dialog dialog, Calendar calendarSelected,
                                      Date dateSelected, int year, String monthFullName,
                                      String monthShortName, int monthNumber, int date,
                                      String weekDayFullName, String weekDayShortName,
                                      int hour24, int hour12, int min, int sec,
                                      String AM_PM) {
                        editText_dueDate
                                .setText(calendarSelected
                                        .get(Calendar.DAY_OF_MONTH)
                                        + "/" + (monthNumber + 1) + "/" + year
                                        + ", " + hour12 + ":" + min
                                        + " " + AM_PM);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
        /**
         * Pass Directly current time format it will return AM and PM if you set
         * false
         */
        custom.set24HourFormat(false);
        /**
         * Pass Directly current data and time to show when it pop up
         */
        custom.setDate(Calendar.getInstance());

        editText_dueDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        custom.showDialog();
                    }
                });


    } // end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
//            startActivity(new Intent(getApplicationContext(), AllTaskList.class));
            finish();
            return true;
        }

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
