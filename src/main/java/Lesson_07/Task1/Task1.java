package Lesson_07.Task1;

import Lesson_07.Task1.Annotations.AfterSuite;
import Lesson_07.Task1.Annotations.BeforeSuite;
import Lesson_07.Task1.Annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Task1 {
    private static String packageName;
    private static Class testClass;
    private static Method before = null;
    private static Method after = null;
    private static Map<Integer, Method> map = new TreeMap<>();

    static {
        packageName = Task1.class.getPackage().getName();
    }

    public static void main(String[] args) {
        start("TestClass");
    }

    public static void start(Class className){
        testClass = className.getClass();
        mainStart();
    }

    public static void start(String strClassname) {
        try {
            testClass = Class.forName(packageName + "." + strClassname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mainStart();
    }

    public static void mainStart() {
        Method[] methods = testClass.getDeclaredMethods();
        for(Method m : methods){
            checkForSingle(m);
            if (m.isAnnotationPresent(Test.class)){
                map.put(m.getAnnotation(Test.class).priority(), m);
            }
        }

        try {
            Object test = testClass.getConstructor().newInstance();
            before.invoke(test);

            map.entrySet().forEach(set -> {
                try {
                    set.getValue().invoke(test);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            after.invoke(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkForSingle(Method m) {
        if (m.isAnnotationPresent(BeforeSuite.class)) {
            if (before == null) {
                before = m;
            } else {
                throw new RuntimeException();
            }
        }

        if (m.isAnnotationPresent(AfterSuite.class)){
            if (after == null){
                after = m;
            } else{
                throw new RuntimeException();
            }
        }
    }
}
