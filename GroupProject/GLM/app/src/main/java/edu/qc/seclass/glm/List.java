package edu.qc.seclass.glm;

import java.util.ArrayList;

public class List {
    boolean check = false;
    String name;
    ArrayList<Reminder> reminders = new ArrayList<Reminder>();

    List(String name) {
        this.name = name;
    }
}