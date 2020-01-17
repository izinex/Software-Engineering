package edu.qc.seclass.glm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class EditReminder extends AppCompatActivity {
    public static Reminder reminderItem;
    public static String index = "";
    public static String changed = "";

    Button save;
    Button cancel;
    TextView oldReminder;
    TextView oldTime;
    EditText newReminder;
    EditText newMonth;
    EditText newDay;
    EditText newHour;
    EditText newMinute;
    ToggleButton ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_edit);
        getSupportActionBar().setTitle("EDIT REMINDER");
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        oldReminder = findViewById(R.id.oldReminder);
        oldTime = findViewById(R.id.oldTime);
        newReminder = findViewById(R.id.newReminder);
        newMonth = findViewById(R.id.newMonth);
        newDay = findViewById(R.id.newDay);
        newHour = findViewById(R.id.newHour);
        newMinute = findViewById(R.id.newMinute);
        ampm = findViewById(R.id.ampm);

        oldReminder.setText(ViewReminder.reminderItem.name);
        oldTime.setText(ViewReminder.reminderItem.month + "/" + ViewReminder.reminderItem.month + " " + ViewReminder.reminderItem.hour + ":" + ViewReminder.reminderItem.minute);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newReminder.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Reminder can not be empty", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(newMonth.getText().toString()) > 12 || Integer.parseInt(newMonth.getText().toString()) < 1) {
                    Toast.makeText(getApplicationContext(), "Invalid month", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(newDay.getText().toString()) > 31 || Integer.parseInt(newMonth.getText().toString()) < 1) {
                    Toast.makeText(getApplicationContext(), "Invalid day", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(newHour.getText().toString()) > 12 || Integer.parseInt(newHour.getText().toString()) < 1) {
                    Toast.makeText(getApplicationContext(), "Invalid hour", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(newMinute.getText().toString()) > 60 || Integer.parseInt(newMinute.getText().toString()) < 0) {
                    Toast.makeText(getApplicationContext(), "Invalid minute", Toast.LENGTH_SHORT).show();
                } else {
                    changed = "yes";
                    reminderItem = ViewReminder.reminderItem;
                    reminderItem.name = newReminder.getText().toString();
                    reminderItem.month = Integer.parseInt(newMonth.getText().toString());
                    reminderItem.day = Integer.parseInt(newDay.getText().toString());
                    reminderItem.hour = Integer.parseInt(newHour.getText().toString());
                    reminderItem.minute = Integer.parseInt(newMinute.getText().toString());
                    reminderItem.ampm = ampm.isChecked();
                    index = ViewReminder.index;
                    Saved();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changed = "no";
                Canceled();
            }
        });
    }

    public void Canceled() {
        Intent intent = new Intent(this, ViewReminder.class);
        startActivity(intent);
    }

    public void Saved() {
        Intent intent = new Intent(this, ViewReminder.class);
        startActivity(intent);
    }
}