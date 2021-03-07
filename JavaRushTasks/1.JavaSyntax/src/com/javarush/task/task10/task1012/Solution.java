package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Алфавит
        int [] count = new int[33];
        for (int i = 0; i < count.length; i++) {
            count[i]=0;
        }
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');
        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }
        reader.close();

        for (int i = 0; i < list.size(); i++) { //перебор строк
            for (int j = 0; j < list.get(i).length(); j++) { //перебок символов в строке
                char c = list.get(i).charAt(j); //j-й символ в i-й строке
                if(alphabet.contains(c))
                    count[alphabet.indexOf(c)]++;
            }
        }
        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i)+" - " + count[i]);

        }
        // напишите тут ваш код

    }
}