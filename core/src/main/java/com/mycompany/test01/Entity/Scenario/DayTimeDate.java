package com.mycompany.test01.Entity.Scenario;

public class DayTimeDate extends DayDate {
    private int hour = 0;
    private int minute = 0;

    public DayTimeDate() {
        super();
    }

    public DayTimeDate(int day, int month, int year, int hour, int minute) {
        super(day, month, year);
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
