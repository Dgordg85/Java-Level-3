package Lesson_03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Task2 extends FileCarousel {

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        String fileName = "task2-";

        task2.createFiles(fileName, 5, 100);
        task2.stickFiles(fileName);
        task2.printFIle();
    }

    public void createFiles(String filename, int count, int size){
        for (int i = 1; i <= count; i++) {
            createFile(filename + i, size);
        }
    }

    public void stickFiles(String reg){
        ArrayList<InputStream> al =  getFilesStreamsArrayList(reg);
        Enumeration<InputStream> e = Collections.enumeration(al);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(new File(getPath() + "task2-output.txt"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            while(e.hasMoreElements()) {
                fos.write(e.nextElement().readAllBytes());
            }
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
