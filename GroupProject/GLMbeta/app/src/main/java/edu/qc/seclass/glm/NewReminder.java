package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TimePicker;

public class NewReminder extends AppCompatActivity implements View.OnClickListener
{
    static Button dateButton;
    static Button timeButton;
    private Switch switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reminder);

        Button save = findViewById(R.id.saveReminder);
        save.setOnClickListener(this);

        Button cancel = findViewById(R.id.cancelReminder);
        cancel.setOnClickListener(this);

        getSupportActionBar().setTitle("NEW REMINDER");

        dateButton =  findViewById(R.id.setDateButton);
        timeButton =  findViewById(R.id.setTimeButton);

        findViewById(R.id.reminderDateIncrement).setVisibility(View.INVISIBLE);
        findViewById(R.id.reminderMinuteIncrement).setVisibility(View.INVISIBLE);
        findViewById(R.id.dayIncrementText).setVisibility(View.INVISIBLE);
        findViewById(R.id.minIncrementText).setVisibility(View.INVISIBLE);

        switchButton = findViewById(R.id.switchRepeat);
        if (switchButton != null) {
            switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                    {
                       findViewById(R.id.reminderDateIncrement).setVisibility(View.VISIBLE);
                        findViewById(R.id.reminderMinuteIncrement).setVisibility(View.VISIBLE);
                        findViewById(R.id.dayIncrementText).setVisibility(View.VISIBLE);
                        findViewById(R.id.minIncrementText).setVisibility(View.VISIBLE);
                    } else
                        {
                            findViewById(R.id.reminderDateIncrement).setVisibility(View.INVISIBLE);
                            findViewById(R.id.reminderMinuteIncrement).setVisibility(View.INVISIBLE);
                            findViewById(R.id.dayIncrementText).setVisibility(View.INVISIBLE);
                            findViewById(R.id.minIncrementText).setVisibility(View.INVISIBLE);


                    }
                }
            });
        }

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.cancelReminder:
            {
                //verify nothing changed
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
            case R.id.saveReminder:
            {
                //created a new reminder then goes back
                Intent j= new Intent(this, MainActivity.class);
                startActivity(j);
            }
        }
    }
    @Override
    public void onBackPressed()
    {
        // Simply Do noting to avoid inconsistent state
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener
    {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c;
            int hour = 0;
            int minute = 0;

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                c = Calendar.getInstance();

                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);
            }
            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute)
        {
            // Do something with the time chosen by the user

            String val = hourOfDay + " : " + minute;
            timeButton.setText(val);
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c;
            int year = 0;
            int month = 0;
            int day = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
            }

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day)
        {
          //Button x =  findViewById(R.id.setDateButton);
          String text = month + " / " + day + " / " +  year;
          dateButton.setText(text);
            // Do something with the date chosen by the use
        }
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
