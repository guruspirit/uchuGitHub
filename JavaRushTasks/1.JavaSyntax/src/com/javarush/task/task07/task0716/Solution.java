package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код

        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < strings.size(); i++) {      // перебираем все строки в списке strings

            String text = strings.get(i).toString();    // text хранит каждую строку списка
            boolean isR=false, isL=false;
            for (int j = 0; j < text.length(); j++) {   //перебираем символы в строке text
                Character ch = text.charAt(j);
                if(ch.equals('р'))
                    isR=true;
                    //System.out.println("check1");}
                if(ch.equals('л'))
                    isL=true;
                    //System.out.println("check2");}
            }
            if(isR&&!isL){
                //System.out.println("check3");
                continue;
            } else if(!isR&&isL){
                result.add(strings.get(i));
                result.add(strings.get(i));
            } else
                result.add(strings.get(i));
        }
        return result;

    }
}