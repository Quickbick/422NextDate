package org.cpts422;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Date {

    private final int day;
    private final int month;
    private final int year;


    private static final int DECEMBER = 12;

    private static final Set<Integer> ThirtyDayMonths = new HashSet<>(Arrays.asList(4,6,9,11));
    private static final Set<Integer> ThirtyOneDayMonths = new HashSet<>(Arrays.asList(1,3,5,7,8,10));


    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidYear(int year){
        return year>=1812 && year <=2023;
    }

    public static boolean isValidMonth(int month){
        return month>=1 && month<=12;
    }

    public static boolean isValidDay(int day){
        return day>=1 && day<=31;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public static boolean isValidInput(int day, int month, int year){
        return isValidDay(day) && isValidMonth(month) && isValidYear(year);
    }

    private boolean isThirtyDayMonths(){
        return ThirtyDayMonths.contains(this.month);
    }

    private boolean isThirtyOneDayMonths(){
        return ThirtyOneDayMonths.contains(this.month);
    }



    public Date nextDate(){
        int nextDay = this.day;
        int nextMonth = this.month;
        int nextYear = this.year;
        if(this.isThirtyDayMonths()){
            if(this.day < 30){
                nextDay = this.day + 1;
            }else {
                nextDay = 1;
                nextMonth = this.month+1;
            }
        } else if (this.isThirtyOneDayMonths()) {
            if(this.day < 31){
                nextDay = this.day + 1;
            }else{
                nextDay = 1;
                nextMonth = this.month+1;
            }
        } else if (this.month == DECEMBER) {
            if(this.day < 31){
                nextDay = this.day + 1;
            }else{
                nextDay = 1;
                nextMonth = 1;
                nextYear = this.year + 1;
            }
        } else{
            if(this.day < 28){
                nextDay = this.day+1;
            } else if (this.day == 28) {
                if(this.isLeapYear()){
                    nextDay = this.day+1;
                }else{
                    nextDay = 1;
                    nextMonth = this.month + 1;
                }
            } else if(this.day == 29){
                if(this.isLeapYear()){
                    nextDay = 1;
                    nextMonth = this.month + 1;
                }else{
                    System.out.println("Invalid input, not a leap year");
                }
            }
        }
        return new Date(nextDay,nextMonth,nextYear);
    }

    private boolean isLeapYear() {
        return this.year % 400 ==0 || (this.year % 4 == 0 && this.year % 100 != 0);
    }

}
