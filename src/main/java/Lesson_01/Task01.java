package Lesson_01;

import java.util.Arrays;

/*
Написать метод, который меняет два элемента массива местами.
(массив может быть любого ссылочного типа);
 */
public class Task01<T> {
    private T[] arr;

    public Task01(T[] arr) {
        this.arr = arr;
    }

    public void changeElems(int firstElem, int secondElem){
        T tempElem = arr[firstElem];
        arr[firstElem] = arr[secondElem];
        arr[secondElem] = tempElem;
    }

    public void printArray(){
        System.out.println(Arrays.toString(arr));
    }


}

