package Lesson_01;

public class Test01 {
    public static void main(String[] args) {
        Integer intArr[] = {1, 2, 3, 4, 5};
        Task01<Integer> massive = new Task01<>(intArr);
        massive.printArray();
        massive.changeElems(0,4);
        massive.printArray();

        String strArr[] = {"a", "b", "c"};
        Task01<String> massive2 = new Task01<>(strArr);
        massive2.printArray();
        massive2.changeElems(0,2);
        massive2.printArray();
    }
}
