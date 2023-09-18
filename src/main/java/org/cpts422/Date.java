package org.cpts422;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Date {

    private final int day;

    private final int month;

    private final int year;

    private static final Set<Integer> THIRTY_DAY_MONTHS = new HashSet<>(Arrays.asList(4,6,9,11));

    private static final Set<Integer> THIRTYONE_DAY_MONTHS = new HashSet<>(Arrays.asList(1,3,5,7,8,10));

    private static final int DECEMBER = 12;
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDay(int day){
        return day>=1 && day<=31;
    }
    public static boolean isValidMonth(int month){
        return month>=1 && month <=12;
    }

    public static boolean isValidYear(int year){
        return  year>=1812 && year<=2023;
    }

    public static boolean isLeapYear(Date date){
        return date.year % 400 == 0 || (date.year % 4 == 0 && date.year%100 !=0);
    }

    public Date nextDate(){
        int nextDay = this.day;
        int nextMonth = this.month;
        int nextYear = this.year;
        if(THIRTY_DAY_MONTHS.contains(this.month)){
            if(this.day < 30){
                nextDay = this.day + 1;
            }else{
                nextDay = 1;
                nextMonth = this.month + 1;
            }
        } else if (THIRTYONE_DAY_MONTHS.contains(this.month)) {
            if(this.day < 31){
                nextDay = this.day + 1;
            }else{
                nextDay = 1;
                nextMonth = this.month + 1;
            }
        } else if (this.month == DECEMBER) {
            if(this.day < 31){
                nextDay = this.day + 1;
            }else{
                nextDay = 1;
                nextMonth = 1;
                nextYear = this.year + 1;
            }
        } else {
            if (this.day < 28){
                nextDay = this.day + 1;
            } else if (this.day == 28) {
                if(isLeapYear(this)){
                    nextDay = this.day + 1;
                }else{
                    nextDay = 1;
                    nextMonth = this.month + 1;
                }
            } else if (this.day == 29) {
                if(isLeapYear(this)){
                    nextDay = 1;
                    nextMonth = this.month + 1;
                }else{
                    throw new RuntimeException(" Wrong input, this year does not have Feb 29th");
                }
            }
        }
        return new Date(nextDay,nextMonth,nextYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date date)) return false;

        if (day != date.day) return false;
        if (month != date.month) return false;
        return year == date.year;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
