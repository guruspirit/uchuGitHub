package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) { }
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }
    public static void systemOutPrintln(String fileName) throws InterruptedException{
        ReadFileThread f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        FileReader fileReader;
        private volatile String str;
        private List<String> list = new ArrayList<>();
        public ReadFileThread(){

        }
        @Override
        public void setFileName(String fullFileName){
            //устанавливает имя файла, из которого будет читаться
            // содержимое
            try {
                fileReader = new FileReader(fullFileName);
            } catch (FileNotFoundException e) {            }
        }

        @Override
        public String getFileContent() {
            //возвращает содержимое файла
            String tmp="";
            for (int i = 0; i < list.size(); i++) {
                //разделить пробелом строки файла
                if(i>0) tmp+=" ";
                tmp+= list.get(i);
            }
            if(isAlive())
                return tmp;
            else
                return "";
        }
        public void run(){
            try {
                //считать содержимое файла
                BufferedReader reader = new BufferedReader(fileReader);
                while (reader.ready())
                    list.add(reader.readLine());
                //закрыть поток
                fileReader.close();
                System.out.println(getFileContent());
            } catch (IOException e) { }
        }
    }

    public interface ReadFileInterface {
        void setFileName(String fullFileName) throws FileNotFoundException;
        String getFileContent() throws IOException;
        void join() throws InterruptedException;
        void start();
    }
}