package Lesson_07.Task1;

import Lesson_07.Task1.Annotations.AfterSuite;
import Lesson_07.Task1.Annotations.BeforeSuite;
import Lesson_07.Task1.Annotations.Test;

public class TestClass {

    public TestClass() {
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("Выполнился тест 1 - приоритет 1");
    }

    @Test
    public void test2(){
        System.out.println("Выполнился тест 2 - приоритет default(5)");
    }

    @Test(priority = 10)
    public void test3(){
        System.out.println("Выполнился тест 3 - приоритет 10");
    }

    @Test(priority = 7)
    public void test4(){
        System.out.println("Выполнился тест 4 - приоритет 7");
    }

    @AfterSuite
    public void endMethod(){
        System.out.println("Выполнился конечный метод");
    }

    @BeforeSuite
    public void startMethod(){
        System.out.println("Выполнился начальный метод");
    }
}
