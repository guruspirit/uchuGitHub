package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputDate = reader.readLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd', 'yyyy", myDateFormatSymbols);
            Date myDate = java.sql.Date.valueOf(inputDate);
            System.out.println(simpleDateFormat.format(myDate));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){
            @Override
        public String[] getMonths(){
                return new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
            }
    };

}
