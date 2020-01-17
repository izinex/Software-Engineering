package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import static edu.qc.seclass.glm.ItemsAdapter.*;
import static edu.qc.seclass.glm.R.color.colorChecked;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private  final static String TAG = "tag";
    protected static HashMap<String,List> database = new HashMap<String,List>();
    private RecyclerView recyclerView;
    private Button addList;
    //private Button addReminder;
    private static int ctr = 0;

    //?????
    public class testclass implements Serializable {
        int bark = 5;
        String thun = "mak";
    }

    public static boolean hasList(String list) {
        return database.containsKey(list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addList = findViewById(R.id.newListButton);
        addList.setOnClickListener(this);

        if(ctr == 0)
        {
            System.out.print("LLLLLLLL main" + ctr);
            ctr = 1;
            Toast toast = Toast.makeText(getApplicationContext(), "Click to View, Hold to Edit", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }

 /*       addReminder = findViewById(R.id.newReminderButton);
        addReminder.setOnClickListener(this);*/

        recyclerView = findViewById(R.id.recyleView);

        //mock data
        Reminder a = new Reminder
                ("Buy beef", false, false,
                        new Date(2019,8,12), new Time(1,50,00), 0,0, null);
        Reminder b = new Reminder
                ("Buy chicken", false, false,
                        new Date(2019,8,12), new Time(2,47,00), 0,0, null);
        Reminder c = new Reminder
                ("Party", false, false,
                        new Date(2019,8,12), new Time(17,49,00), 0,0, null);


        ArrayList<Reminder> remindersOne = new ArrayList<Reminder>();
        remindersOne.add(a);
        remindersOne.add(b);
        ArrayList<Reminder> remindersTwo = new ArrayList<Reminder>();
        remindersTwo.add(c);

        database.put("Grocery", new List(remindersOne, "Grocery"));
        database.put("Weekend", new List(remindersTwo, "Weekend"));


         //to add items to home page, does automatically to items of database see in new list
        //below is the
        final ItemsAdapter adapter = new ItemsAdapter(database);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // final List testerList = database.get("Grocery");


//        final  testclass yin = new testclass();
//        yin.bark =9;
//        yin.thun="game";

        /*               Toast toast = Toast.makeText(getApplicationContext(),
                       testerList.getName(0).getName(),
                Toast.LENGTH_SHORT);
        toast.show();*/

        adapter.setOnClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(int position)
            {
                String g = String.valueOf(Objects.requireNonNull(database.keySet().toArray())[position]);
                final TextView v  = (TextView) Objects.requireNonNull(recyclerView.getLayoutManager()).findViewByPosition(position);
                if (v != null)
                {
                    final String list = v.getText().toString();
                    //v.setText((R.string.clicked));

                    //example of resetting value
                  // Handler handler = new Handler();
                    //handler.postDelayed(new Runnable() {
                       // public void run() {
                           // v.setText(a);
                       // }
                  //  }, 2000);
                 // v.setText(a);


                    final ArrayList<Reminder> temp = database.get(list).getReminderList();
                    Intent intent = new Intent(MainActivity.this, ListPage.class);
                    intent.putExtra("subjectList", temp);
                    intent.putExtra("listName", v.getText().toString());

                    startActivity(intent);
                    //go to reminder list view
//                    Intent i = new Intent(MainActivity.this, ListPage.class);
//                    i.putExtra("listName", v.getText().toString());
//                    startActivity(i);
                }
            }


        });

        adapter.setOnLongClickListener(new View.OnLongClickListener()
        {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onLongClick(View view)
            {
                Intent i = new Intent(MainActivity.this, EditList.class);
                i.putExtra("listName", ((TextView)view).getText().toString());
                startActivity(i);

//                TextView t = (TextView) view;
//
//                    if (t.getText().toString().substring(0,1).equals("\u2611"))
//                    {
//                        t.setBackgroundColor(Color.rgb(233,63,63));
//                        String uncheckedMark = "\u2610";
//                        String result = uncheckedMark.concat(t.getText().toString().substring(t.getText().toString().indexOf(" ")));
//                        t.setText(result);
//                        return true;
//
//                    }
//                    else {
//                        t.setBackgroundColor(Color.rgb(59, 225, 54));
//                        String checkedMark = "\u2611";
//                        String result = checkedMark.concat(t.getText().toString());//.substring(t.getText().toString().indexOf(" ")));
//                        t.setText(result);
//                        return true;
//                    }
                return true;
            }
        });
       
        getSupportActionBar().setTitle("HOME");

    }

    @Override
    public void onBackPressed()
    {
        // Simply Do noting to avoid inconsistent state
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.newListButton:
            {
                Log.i(TAG, "Inside new list case");
                Intent i = new Intent(this, NewList.class);

                //how info is passed back and forth
                //EditText editText = (EditText) findViewById(R.id.editText);
                //String message = editText.getText().toString();
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(i);
                break;
            }

 /*            case R.id.newReminderButton:
            {
                Log.i(TAG, "Inside new reminder case");
                Intent j = new Intent(this, NewReminder.class);
                startActivity(j);
                break;
            }*/
            //case is new list create intent to new list
            // case is new reminder create intent to new reminder
        }
    }
}
