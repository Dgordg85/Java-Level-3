package Lesson_03;

public class Task1 extends FileCarousel {

    public static void main(String[] args) {
        Task1 file1 = new Task1();
        file1.createFile("task1.1", 50);
        file1.printFIle();

        Task1 file2 = new Task1();
        file2.createFile("task1.2", 50);
        file2.printFIle();
    }
}
