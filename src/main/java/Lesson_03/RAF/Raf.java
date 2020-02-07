package Lesson_03.RAF;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class Raf {
    private static final int PAGE_SIZE = 1800;
    private RandomAccessFile raf;
    private byte[] buffer = new byte[PAGE_SIZE];
    private long pageCount;

    public Raf(File file) {
        try {
            raf = new RandomAccessFile(file, "r");
            pageCount = raf.length() / PAGE_SIZE + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Raf raf = new Raf(new File("src/main/java/Lesson_03/master.txt"));

        Scanner sc = new Scanner(System.in);
        int page;
        while(true){
            System.out.println("Введите номер страницы... Всего " + raf.getPageCount() + " страниц(ы).");
            page = sc.nextInt();
            long t = System.currentTimeMillis();
            raf.getRandomPage(page);
            System.out.println("Время формирование страниц: " + ((System.currentTimeMillis() - t) / 1000f) + "c");
        }
    }


    private void getRandomPage(int page){
        try {
            raf.seek(PAGE_SIZE * page);
            raf.read(buffer);
            System.out.println(Arrays.toString(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public long getPageCount() {
        return pageCount;
    }
}
