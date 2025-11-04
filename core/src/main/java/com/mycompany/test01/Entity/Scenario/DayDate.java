package com.mycompany.test01.Entity.Scenario;

public class DayDate {
    private int day = 1;
    private int month = 1;
    private int year = 1;

    public DayDate() {
    }

    public DayDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getMonthDuration() {
        if(
            month == 1 ||
            month == 3 ||
            month == 5 ||
            month == 7 ||
            month == 8 ||
            month == 10 ||
            month == 12
        ) {
            return 31;
        }
        else {
            if(month == 2) {
                return 28;
            }
            return 30;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = Math.min(day, this.getMonthDuration());
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day +
            "/" + month +
            "/" + year;
    }
}
