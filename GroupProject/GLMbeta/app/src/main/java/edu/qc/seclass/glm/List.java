package edu.qc.seclass.glm;

import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import androidx.recyclerview.widget.RecyclerView;

public class List implements Serializable//extends RecyclerView.Adapter<List.MyViewHolder>
{
    ArrayList<Reminder> reminderList;
    private String name; //list name

    // follow this tutorial to implement class commneted out above  https://developer.android.com/guide/topics/ui/layout/recyclerview
//    public static class MyViewHolder extends RecyclerView.ViewHolder
//    {
//        // each data item is just a string in this case
//        public TextView textView;
//        public MyViewHolder(TextView v) {
//            super(v);
//            textView = v;
//        }
//    }
    public List(ArrayList<Reminder> reminderList, String name)
    {
        this.reminderList = reminderList;
        this.name = name;
    }

    public List()
    {
        reminderList = null;
        name = null;
    }
    public ArrayList<Reminder> getReminderList()
    {
        return reminderList;
    }

    public void setReminderList(ArrayList<Reminder> reminderList)
    {
        this.reminderList = reminderList;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
