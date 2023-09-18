package org.cpts422;

public class Main {
    public static void main(String[] args) {

        int day = Integer.parseInt(args[1]);
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[2]);

        if(!Date.isValidDay(day)){
            System.out.println("day not valid");
        } else if (!Date.isValidMonth(month)) {
            System.out.println("month not valid");
        } else if (!Date.isValidYear(year)) {
            System.out.println("year not valid");
        }else{
            Date date = new Date(day,month,year);
            System.out.println(date.nextDate());
        }

    }
}