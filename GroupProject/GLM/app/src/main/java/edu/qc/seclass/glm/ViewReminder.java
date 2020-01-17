package edu.qc.seclass.glm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewReminder extends AppCompatActivity {
    public static String name = "";
    public static String index = "";
    public static Reminder reminderItem;
    public static ArrayList<Reminder> updatedReminders;
    public static String changed = "";

    public RecyclerView reminderRecyclerView;
    public ReminderAdapter reminderAdapter;
    public RecyclerView.LayoutManager reminderLayoutManager;

    ArrayList<Reminder> reminders;
    Button buttonReminder;
    Button buttonBack;
    EditText addReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_view);
        reminders = ViewList.reminders;
        buildRecyclerView();
        getSupportActionBar().setTitle("MY REMINDERS");
        buttonReminder = findViewById(R.id.buttonReminder);
        buttonBack = findViewById(R.id.buttonBack);
        addReminder = findViewById(R.id.addReminder);

        if (EditReminder.changed.equals("yes")) {
            reminders.get(Integer.parseInt(EditReminder.index)).name = EditReminder.reminderItem.name;
            index = EditReminder.index;
            EditReminder.changed = "no";
            changed = "yes";
        }

        buttonReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newReminder = addReminder.getText().toString();

                if (reminders.size() != 0) {
                    for (int i = 0; i < reminders.size(); i++) {
                        if (newReminder.equals("")) {
                            Toast.makeText(getApplicationContext(), "Reminder can not be empty", Toast.LENGTH_SHORT).show();
                            break;
                        } else if (!reminders.get(reminders.size() - 1).name.equals(newReminder)) {
                            reminders.add(new Reminder(newReminder));
                            reminderAdapter.notifyItemInserted(reminders.size() - 1);
                            addReminder.setText("");
                        }
                    }
                } else {
                    if (newReminder.equals("")) {
                        Toast.makeText(getApplicationContext(), "Reminder can not be empty", Toast.LENGTH_SHORT).show();
                    } else {
                        reminders.add(new Reminder(newReminder));
                        reminderAdapter.notifyItemInserted(reminders.size() - 1);
                        addReminder.setText("");
                    }
                }
                updatedReminders = reminders;
                index = ViewList.index;
                changed = "yes";
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewList();
            }
        });
    }

    public void openViewList() {
        Intent intent = new Intent(this, ViewList.class);
        startActivity(intent);
    }

    public void removeReminder(int position) {
        reminders.remove(position);
        reminderAdapter.notifyItemRemoved(position);
        updatedReminders = reminders;
        index = ViewList.index;
        changed = "yes";
    }

    public void buildRecyclerView() {
        reminderRecyclerView = findViewById(R.id.reminder);
        reminderRecyclerView.setHasFixedSize(true);
        reminderLayoutManager = new LinearLayoutManager(this);
        reminderAdapter = new ReminderAdapter(reminders);

        reminderRecyclerView.setLayoutManager(reminderLayoutManager);
        reminderRecyclerView.setAdapter(reminderAdapter);

        reminderAdapter.setOnItemClickListener(new ReminderAdapter.OnItemClickListener() {
            @Override
            public void OnDeleteClick(int position) {
                removeReminder(position);
            }

            @Override
            public void OnEditClick(int position) {
                openEditReminder(position);
            }

            @Override
            public void onCheckClick(int position) {
                if (reminders.get(position).check == false) {
                    reminders.get(position).check = true;
                } else if (reminders.get(position).check == true) {
                    reminders.get(position).check = false;
                }
                changed = "yes";
            }
        });
    }

    public void openEditReminder(int position) {
        Intent intent = new Intent(this, EditReminder.class);
        index = String.valueOf(position);
        reminderItem = reminders.get(position);
        startActivity(intent);
    }
}