package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_reminder);

        configureButtons();

        getSupportActionBar().setTitle("EDIT REMINDER");
    }

    private void configureButtons() {
        Button saveEditReminder = findViewById(R.id.saveEditReminder);
        saveEditReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to save stuff here
                finish();
            }
        });

        Button cancelEditReminder = findViewById(R.id.cancelEditReminder);
        cancelEditReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to cancel stuff here
                finish();
            }
        });

    }



}
