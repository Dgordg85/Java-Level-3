package Lesson_04;

import java.io.PrintStream;
import java.util.ArrayList;

public class PrintObject {
    private String letter;
    private String[] rule;
    private int count;
    private static ArrayList<PrintObject> list = new ArrayList<>();

    public String getLetter() {
        return letter;
    }

    public String[] getArr() {
        return rule;
    }

    public PrintObject(String letter, String[] arr, int count) {
        this.letter = letter;
        this.rule = arr;
        this.count = count;
        list.add(this);
    }

    public static ArrayList<PrintObject> getList() {
        return list;
    }

    public int getCount() {
        return count;
    }

    boolean canPrintLetter(String lastChar, Thread thread){
        Boolean result = false;
        for (String s : getArr()){
            if (s.equals(lastChar)){
                result = true;
                break;
            }
        }
        System.out.println("Буква \"" + getLetter() + "\" для потока " + thread.getName() + " Lastchar: \"" + lastChar + "\" правило позволяет напечатать?: " + result);
        return result;
    }

    String printLetter(PrintStream ps){
        ps.println("**********");
        ps.print(getLetter());
        ps.println();
        ps.println("**********");
        return getLetter();
    }
}
