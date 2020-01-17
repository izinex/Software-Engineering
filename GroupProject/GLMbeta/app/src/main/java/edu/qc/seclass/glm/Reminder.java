package edu.qc.seclass.glm;

import android.location.Location;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Reminder implements Serializable
{
    private String name;
    private boolean checked;
    private boolean repeat;
    private Date date;
    private Time time;

    //for repeat increments the instance data
    private int dayIncrement;
    private int minIncrement;

    //extra requirement for location
    private Location  location;

    public Reminder(String name, boolean checked, boolean repeat, Date date, Time time, int dayIncrement, int minIncrement, Location location) {
        this.name = name;
        this.checked = checked;
        this.repeat = repeat;
        this.date = date;
        this.time = time;
        this.dayIncrement = dayIncrement;
        this.minIncrement = minIncrement;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDayIncrement(int dayIncrement) {
        this.dayIncrement = dayIncrement;
    }



    public void setMinIncrement(int minIncrement) {
        this.minIncrement = minIncrement;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String allInfo() {
        return getName() + "   -   " + getDate() + "   -   " + getTime()+ "\n\n";// + getDayIncrement() + " " + " " + getMinIncrement() + " " + getLocation();
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return checked;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public String getDate() {

        return date.getMonth() + "/" + date.getDay() + "/" + date.getYear();
    }

    public String getTime() {
        int hours = time.getHours();
        int minutes = time.getMinutes();


        return hours + " : " + minutes;
    }

    public int getDayIncrement() {
        return dayIncrement;
    }

    public int getMinIncrement() {
        return minIncrement;
    }

    public Location getLocation() {
        return location;
    }
}