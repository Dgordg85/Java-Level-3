package Lesson_03;

public class Task2 extends FileCarousel {

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        String fileName = "task2-";

        task2.createFiles(fileName, 5, 100);
        task2.stickFiles(fileName);
    }

}
