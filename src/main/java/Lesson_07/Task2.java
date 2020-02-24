package Lesson_07;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Task2 {
    public static void main(String[] args) throws Exception {
        File file = new File("D:/JAVA/Java Level 3/src/main/java/");
        URL[] url = new URL[]{file.toURI().toURL()};
        Class ch = URLClassLoader.newInstance(url).loadClass("Lesson_07.Task");

        Method printIsPositive = ch.getDeclaredMethod("printIsPositive", int.class);
        printIsPositive.setAccessible(true);

        Method isNegative = ch.getDeclaredMethod("isNegative", int.class);
        isNegative.setAccessible(true);

        Method printWelcome = ch.getDeclaredMethod("printWelocome", String.class);
        printWelcome.setAccessible(true);

        Method isLeapYear = ch.getDeclaredMethod("isLeapYear", int.class);
        isLeapYear.setAccessible(true);

        Method checkTwoNumbers = ch.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
        checkTwoNumbers.setAccessible(true);

        Method calculateInt = ch.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
        calculateInt.setAccessible(true);

        Method calculateFloat = ch.getDeclaredMethod("calculate", float.class, float.class, float.class, float.class);
        calculateFloat.setAccessible(true);

        printIsPositive.invoke(null, 5);
        System.out.println(isNegative.invoke(null, -50));
        printWelcome.invoke(null,"Андрей");
        System.out.println(isLeapYear.invoke(null, 1988));
        System.out.println(checkTwoNumbers.invoke(null, 5, 7));
        System.out.println(calculateInt.invoke(null, 5, 7, 10, 20));
        System.out.println(calculateFloat.invoke(null, 5f, 7f, 10f, 20f));






    }
}
