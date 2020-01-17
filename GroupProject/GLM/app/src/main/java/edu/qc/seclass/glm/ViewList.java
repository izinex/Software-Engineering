package edu.qc.seclass.glm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

public class ViewList extends AppCompatActivity {
    public static String name = "";
    public static String index = "";
    public static List listItem;
    public static ArrayList<Reminder> reminders;

    public RecyclerView listRecyclerView;
    public ListAdapter listAdapter;
    public RecyclerView.LayoutManager listLayoutManager;

    ArrayList<List> database;
    Button buttonList;
    EditText addList;
    ToggleButton checkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        loadData();
        buildRecyclerView();
        getSupportActionBar().setTitle("MY LISTS");

        if (EditList.changed.equals("yes")) {
            database.get(Integer.parseInt(EditList.index)).name = EditList.listItem.name;
            EditList.changed = "no";
            saveData();
        }

        if (ViewReminder.changed.equals("yes")) {
            database.get(Integer.parseInt(ViewReminder.index)).reminders = ViewReminder.updatedReminders;
            EditList.changed = "no";
            saveData();
        }


        buttonList = findViewById(R.id.buttonList);
        addList = findViewById(R.id.addList);
        checkList = findViewById(R.id.checkList);

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newList = addList.getText().toString();

                if (database.size() != 0) {
                    for (int i = 0; i < database.size(); i++) {
                        if (newList.equals("")) {
                            Toast.makeText(getApplicationContext(), "List can not be empty", Toast.LENGTH_SHORT).show();
                            break;
                        } else if (database.get(i).name.equals(newList)) {
                            Toast.makeText(getApplicationContext(), "List already exists", Toast.LENGTH_SHORT).show();
                            break;
                        } else if (!database.get(database.size() - 1).name.equals(newList) && i == database.size() - 1) {
                            database.add(new List(newList));
                            listAdapter.notifyItemInserted(database.size() - 1);
                            addList.setText("");
                            saveData();
                            break;
                        }
                    }
                } else {
                    if (newList.equals("")) {
                        Toast.makeText(getApplicationContext(), "List can not be empty", Toast.LENGTH_SHORT).show();
                    } else {
                        database.add(new List(newList));
                        listAdapter.notifyItemInserted(database.size() - 1);
                        addList.setText("");
                        saveData();
                    }
                }
            }
        });
        checkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked++;
                checkAll();
            }
        });

        Calendar now = Calendar.getInstance();
        for (int i = 0; i < database.size(); i++) {
            for (int j = 0; j < database.get(i).reminders.size(); j++) {
                if (database.get(i).reminders.get(j).month == (now.get(Calendar.MONTH) + 1)) {
                    if (database.get(i).reminders.get(j).day == (now.get(Calendar.DATE))) {
                        if (database.get(i).reminders.get(j).hour == (now.get(Calendar.HOUR))) {
                            if (database.get(i).reminders.get(j).minute == (now.get(Calendar.MINUTE))) {
                                if (now.get(Calendar.AM_PM) == (database.get(i).reminders.get(j).ampm ? 1 : 0)) {
                                    timeNotification(i, j);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void timeNotification(int i, int j) {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, ViewList.class), 0);
        Resources r = getResources();
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker(database.get(i).reminders.get(j).name)
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle(database.get(i).name)
                .setContentText(database.get(i).reminders.get(j).name)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    int checked = 0;

    public void checkAll() {
        if (checked % 2 == 0) {
            for (int i = 0; i < database.size(); i++) {
                database.get(i).check = true;
                listAdapter.notifyItemChanged(i);
            }
        } else {
            for (int i = 0; i < database.size(); i++) {
                database.get(i).check = false;
                listAdapter.notifyItemChanged(i);
            }
        }
    }

    public void removeList(int position) {
        database.remove(position);
        listAdapter.notifyItemRemoved(position);
    }

    public void buildRecyclerView() {
        listRecyclerView = findViewById(R.id.list);
        listRecyclerView.setHasFixedSize(true);
        listLayoutManager = new LinearLayoutManager(this);
        listAdapter = new ListAdapter(database);

        listRecyclerView.setLayoutManager(listLayoutManager);
        listRecyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                saveData();
                openViewReminder(position);
            }

            @Override
            public void OnDeleteClick(int position) {
                removeList(position);
                saveData();
            }

            @Override
            public void OnEditClick(int position) {
                saveData();
                openEditList(position);
            }

            @Override
            public void onCheckClick(int position) {
                if (database.get(position).check == false) {
                    database.get(position).check = true;
                } else if (database.get(position).check == true) {
                    database.get(position).check = false;
                }
                saveData();
            }
        });
    }

    public void openEditList(int position) {
        Intent intent = new Intent(this, EditList.class);
        index = String.valueOf(position);
        listItem = database.get(position);

        startActivity(intent);
    }

    public void openViewReminder(int position) {
        Intent intent = new Intent(this, ViewReminder.class);
        index = String.valueOf(position);
        reminders = database.get(position).reminders;
        startActivity(intent);
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(database);
        editor.putString("GLM", json);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("GLM", null);
        Type type = new TypeToken<ArrayList<List>>() {
        }.getType();
        database = gson.fromJson(json, type);
        if (database == null) {
            database = new ArrayList<>();
        }
    }
}