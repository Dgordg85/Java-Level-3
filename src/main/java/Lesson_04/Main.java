package Lesson_04;

public class Main {

    public static void main(String[] args) {
        new PrintObject("C", new String[]{"B"}, 5);
        new PrintObject("A", new String[]{"C", ""}, 5);
        new PrintObject("B", new String[]{"A"}, 5);

        for (PrintObject obj: PrintObject.getList()){
            new MyThreads(obj).start();
        }
    }
}
