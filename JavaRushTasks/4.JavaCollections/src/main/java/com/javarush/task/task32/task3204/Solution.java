package com.javarush.task.task32.task3204;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        ByteArrayOutputStream bos;
        String password="";
        do {
            bos = new ByteArrayOutputStream();
            for (int i = 0; i < 8; i++) {
                int rnd = new Random().nextInt(62);
                byte x = word.getBytes()[rnd];
                bos.write(x);
            }
            password = bos.toString();
        } while (!isStrongPassword(password));
        return bos;
    }
    public static boolean isStrongPassword(String password) {
        String upSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowSet = "abcdefghijklmnopqrstuvwxyz";
        String numSet = "0123456789";
        boolean isUpExist = contains(password, upSet);
        boolean isDownExist = contains(password, lowSet);
        boolean isNumExist = contains(password, numSet);
        if (isUpExist && isDownExist && isNumExist) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean contains (String password, String set) {
        for (char charOfPassword: password.toCharArray()) {
            if (set.contains(String.valueOf(charOfPassword))) {
                return true;
            }
        }
        return false;
    }
}
