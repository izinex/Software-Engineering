package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);

        configureButtons();
        getSupportActionBar().setTitle("RENAME LIST");
    }




    private void configureButtons() {
        Button saveListEdit = findViewById(R.id.saveListEdit);
        saveListEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here you would save all the data and then finish activity
                finish();
            }
        });

        Button cancelListEdit = findViewById(R.id.cancelListEdit);
        cancelListEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here you would do something then finish activity
                finish();
            }
        });


    }


}
