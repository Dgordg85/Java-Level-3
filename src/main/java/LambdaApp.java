package Lesson_01;

public class LambdaApp {

    public static void main(String[] args) {

        Operationable addition = (a, b) -> (a + b);
        Operationable division = (a, b) -> (a / b);
        Operationable multiplication = (a, b) -> (a * b);

        System.out.println(addition.calculate(7, 8));
        System.out.println(division.calculate(10, 5));
        System.out.println(multiplication.calculate(7, 8));
    }

}
