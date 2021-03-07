package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Гласные и согласные
*/
public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String myStr = reader.readLine();
            char[] myCharStr = myStr.toCharArray();
            String myStrVolwels="";
            String myStrConsonants=""; //consonant - согласная
            for(char c:myCharStr) {
            if(isVowel(c))
                myStrVolwels+=c+" ";
            else if (c==' ')
                continue;
            else
                myStrConsonants+=c+" ";
            }
            System.out.println(myStrVolwels);
            System.out.println(myStrConsonants);
            }
        catch (Exception e){
            System.out.println(e);
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}