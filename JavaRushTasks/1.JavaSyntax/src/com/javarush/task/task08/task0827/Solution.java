package com.javarush.task.task08.task0827;
/*
Работа с датой
*/
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date cDate = new Date();
        cDate.setTime(Date.parse(date));
        Calendar calendar= new GregorianCalendar();
        calendar.setTime(cDate);
        int day=calendar.get(Calendar.DAY_OF_YEAR);
        if(day%2==0)
            return false;
        else
            return true;
    }
}
