package Lesson_02;

public class Main {

    public static void main(String[] args) {
        Crude students = new Crude();
        students.insert("Аркадий", 25);
        students.insert("Семен", 4);
        students.insert("Артем", 28);
        students.insert("Павел", 78);
        students.insert("Анна", 23);
        students.insert("Жанна", 0);
        students.insert("Митя", 5);
        students.select();

        students.update(1, "Николай", 100);
        students.update(2, 200);
        students.update(3, "Владимир");
        students.update(10, "Артем");
        students.select();

        students.delete(1);
        students.delete(15);
        students.select(2);
        students.select();

        Crude.disconnect();
    }
}
