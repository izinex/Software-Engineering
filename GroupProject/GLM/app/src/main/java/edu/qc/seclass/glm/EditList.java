package edu.qc.seclass.glm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditList extends AppCompatActivity {
    public static List listItem;
    public static String index = "";
    public static String changed = "";

    Button save;
    Button cancel;
    TextView oldList;
    EditText newList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_edit);

        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        oldList = findViewById(R.id.oldList);
        newList = findViewById(R.id.newList);

        oldList.setText(ViewList.listItem.name);
        getSupportActionBar().setTitle("EDIT LIST");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newList.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "List can not be empty", Toast.LENGTH_SHORT).show();
                } else {
                    changed = "yes";
                    listItem = ViewList.listItem;
                    listItem.name = newList.getText().toString();
                    index = ViewList.index;
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
        Intent intent = new Intent(this, ViewList.class);
        startActivity(intent);
    }

    public void Saved() {
        Intent intent = new Intent(this, ViewList.class);
        startActivity(intent);
    }
}