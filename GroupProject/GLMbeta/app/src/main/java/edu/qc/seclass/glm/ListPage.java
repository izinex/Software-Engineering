        package edu.qc.seclass.glm;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;
        import static edu.qc.seclass.glm.MainAdapter.*;
        import java.util.ArrayList;
        import java.util.Objects;

        import static edu.qc.seclass.glm.MainActivity.database;

        public class ListPage extends AppCompatActivity{

        private  final static String TAG = "tag";
        RecyclerView mRecyclerView;
        MainAdapter mAdapter;
        ArrayList<Reminder> reminderlist;
        private static int ctr = 0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

getSupportActionBar().setTitle(getIntent().getStringExtra("listName"));

        configureButtons();

            if(ctr == 0)
            {
                ctr = 1;
                Toast toast = Toast.makeText(getApplicationContext(), "Click to Check/Uncheck, Hold to Edit", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
               // ctr++;
            }


        reminderlist = (ArrayList<Reminder>)getIntent().getSerializableExtra("subjectList");
        if (reminderlist == null) {
        Toast toast=Toast.makeText(getApplicationContext(),"u null",Toast.LENGTH_SHORT);
        toast.show();
        } else {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new MainAdapter(reminderlist);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            mAdapter.setOnClickListener(new OnItemClickListener()
            {
                @Override
                public void onItemClick(int position)
                {
                   // TextView t = (TextView) view;
                    TextView t = (TextView) Objects.requireNonNull(mRecyclerView.getLayoutManager()).findViewByPosition(position);
                    if (t.getText().toString().substring(0,1).equals("\u2714")) //if empty square
                    {
                       // t.setBackgroundColor(Color.rgb(233,63,63));
                        t.setBackgroundColor(Color.parseColor("#FAA9A9")); //color red
                       // t.setBackgroundColor(getResoures().getColor(R.color.colorChecked));
                        String uncheckedMark = "\u2750"; //empty
                        String result = uncheckedMark.concat(t.getText().toString().substring(t.getText().toString().indexOf(" ")));
                        t.setText(result);
                       // return true;

                    }
                    else {  // if checked square
                        t.setBackgroundColor(Color.parseColor("#D2FDC6")); //color green
                        String checkedMark = "\u2714"; //checked square
                        String result = checkedMark.concat(t.getText().toString().substring(t.getText().toString().indexOf(" ")));
                        t.setText(result);
                       // return true;
                    }
                }


            });

            mAdapter.setOnLongClickListener(new View.OnLongClickListener()
            {
                @SuppressLint("ResourceAsColor")
                @Override
                public boolean onLongClick(View view)
                {
                    ///////

                    //String g = String.valueOf(Objects.requireNonNull(database.keySet().toArray())[position]);
                    TextView v = (TextView) view;
                    //final TextView v  = (TextView) Objects.requireNonNull(mRecyclerView.getLayoutManager()).findViewByPosition(position);
                    // if (v != null)
                    {
                        final String rem = v.getText().toString();
                        Intent intent = new Intent(ListPage.this, EditReminder.class);
                        intent.putExtra("reminderName", rem);
                        startActivity(intent);
                        //v.setText((R.string.clicked));

                        //example of resetting value
                        // Handler handler = new Handler();
                        //handler.postDelayed(new Runnable() {
                        // public void run() {
                        // v.setText(a);
                        // }
                        //  }, 2000);
                        // v.setText(a);


//                        final ArrayList<Reminder> temp = database.get(list).getReminderList();
//                        Intent intent = new Intent(MainActivity.this, ListPage.class);
//                        intent.putExtra("subjectList", temp);
//                        intent.putExtra("listName", v.getText().toString());

                        // startActivity(intent);
                        //go to reminder list view
//                    Intent i = new Intent(MainActivity.this, ListPage.class);
//                    i.putExtra("listName", v.getText().toString());
//                    startActivity(i);
                    }
                    ///////
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
//                        String result = checkedMark.concat(t.getText().toString().substring(t.getText().toString().indexOf(" ")));
//                        t.setText(result);
//                        return true;
//                    }
                return true;
                }
            });
        }
        //recycler_view








        // getSupportActionBar().setTitle("REMINDERS FROM " + listName.toUpperCase());*/
        }

        private void configureButtons() {
        Button toHome = findViewById(R.id.toHome);
        toHome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        //here you would save all the data and then finish activity
        Intent intent = new Intent(ListPage.this, MainActivity.class);
        startActivity(intent);
        }
        });
        Button addReminder;
        addReminder = findViewById(R.id.newReminderButton);
        addReminder.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {

        Log.i(TAG, "Inside new reminder case");
        //Intent j = new Intent(ListPage.this, NewReminder.class);

        Intent intent = new Intent(ListPage.this, NewReminder.class);
        intent.putExtra("subjectList",reminderlist );
        startActivity(intent);
        //startActivity(j);
        }
        });


        }
        }




//package edu.qc.seclass.glm;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class ListPage extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_page);
//
//
//        configureButtons();
//
//        //how to unbudle intent data set from caller. MainActivity in this case
//        Intent intent = getIntent();
//        String listName = intent.getStringExtra("listName");
//        TextView label = findViewById(R.id.tiptip);
//        String tip = (getString(R.string.lifeHack) + listName).toUpperCase();
//        label.setText(tip);
//
//        getSupportActionBar().setTitle("REMINDERS FROM " + listName.toUpperCase());
//    }
//
//    private void configureButtons() {
//        Button toHome = findViewById(R.id.toHome);
//        toHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //here you would save all the data and then finish activity
//                finish();
//            }
//        });
//
//
//    }
//}