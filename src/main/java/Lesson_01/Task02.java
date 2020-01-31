package Lesson_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Task02<T> {

    public static void main(String[] args) {
        Integer[] arrInt = {7, 3, 5, 8};
        Task02<Integer> task02 = new Task02<>();
        List<Integer> list = task02.arrayToList(arrInt);
    }

    public List<T> arrayToList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
