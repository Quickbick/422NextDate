package org.cpts422;

public class Main {
    public static void main(String[] args) {
        int day = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        if(Date.isValidInput(day, month, year)){
            Date date = new Date(day,month,year);
            System.out.println("Current Date: ");
            System.out.println(date);
            System.out.println("Next Date: ");
            System.out.println(date.nextDate());
        }else{
            System.out.println("Invalid input: correct your day, month or year");
        }
    }
}