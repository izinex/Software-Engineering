package edu.qc.seclass.glm;

public class Reminder {

    public boolean check = false;
    public String name;
    public boolean time = false;
    public int month = 0;
    public int day = 0;
    public int hour = 0;
    public int minute = 0;
    public boolean ampm = false;

    Reminder(String name) {
        this.name = name;
    }

    Reminder(String name, int month, int day, int hour, int minute) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
}