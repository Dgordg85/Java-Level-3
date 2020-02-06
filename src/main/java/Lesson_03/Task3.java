package Lesson_03;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    private final int BUFFER_SIZE = 1800;
    private String filePath;
    private ArrayList<char[]> list = new ArrayList<>();

    public Task3(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        Long t = System.currentTimeMillis();
        Task3 task3 = new Task3("src/main/java/Lesson_03/master.txt");
        task3.divideFileToPages();

        Scanner sc = new Scanner(System.in);
        System.out.println("Время формирование страниц: " + ((System.currentTimeMillis() - t) / 1000f) + "c");
        System.out.println("Введите номер страницы... Всего " + task3.getListSize() + " страниц(ы).");

        int pageNumber = sc.nextInt();
        while(pageNumber > 0 && pageNumber <= task3.getListSize()){
            System.out.println(task3.list.get(pageNumber - 1));
            pageNumber = sc.nextInt();
        }

    }

    private void divideFileToPages(){
        BufferedReader reader = null;
        char[] buffer = new char[BUFFER_SIZE];
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            while (reader.ready()){
                reader.read(buffer, 0, BUFFER_SIZE);
                list.add(buffer.clone());
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public int getListSize() {
        return list.size();
    }
}
