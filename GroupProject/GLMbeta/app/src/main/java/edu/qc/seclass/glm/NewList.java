package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewList extends AppCompatActivity implements View.OnClickListener{



    TextView textView;
    Button save;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_list);
        save = findViewById(R.id.saveList);
        save.setOnClickListener(this);
       cancel = findViewById(R.id.cancelList);
        cancel.setOnClickListener(this);
        getSupportActionBar().setTitle("NEW LIST");
        textView = findViewById(R.id.listName);

    }

    @Override
    public void onClick(View view)
    {
       switch (view.getId())
       {
           case R.id.cancelList:
           {

               //must verify that nothing was changed
               Intent i = new Intent(this, MainActivity.class);
               startActivity(i);
               break;
           }
           case R.id.saveList:
           {
               if(textView.getText().toString().equals(""))
               {
                   Toast toast = Toast.makeText(getApplicationContext(), "Enter List Name", Toast.LENGTH_LONG);
                   toast.show();
               }
               else  if(!MainActivity.hasList(textView.getText().toString()))
               {
                   MainActivity.database.put(textView.getText().toString(), new List());
                   Intent j = new Intent(this, MainActivity.class);
                   startActivity(j);
               }

               else
               {
                   Toast toast = Toast.makeText(getApplicationContext(), "List already Exists", Toast.LENGTH_LONG);
                   toast.show();
               }
               //has to send data back for list created or create list
               //Intent j = new Intent(this, MainActivity.class);
               //startActivity(j);
               //break;
           }
       }
    }
    @Override
    public void onBackPressed()
    {
        // Simply Do noting to avoid inconsistent state
    }
}
