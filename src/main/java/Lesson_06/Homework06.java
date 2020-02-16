package Lesson_06;

import java.util.Arrays;


public class Homework06 {

    public int[] getMassiveByLast4(int[] array){
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4){
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new RuntimeException();
    }

    public boolean isOneOrFourInArray(int[] array){
        if (array != null){
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 1 || array[i] == 4){
                    return true;
                }
            }
        }
        return false;
    }
}
