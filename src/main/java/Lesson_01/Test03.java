package Lesson_01;

public class Test03 {

    public static void main(String[] args) {
        //1
        Box<Apple> boxApple = new Box<>();
        boxApple.putFruit(new Apple());
        boxApple.putFruit(new Apple());
        boxApple.putFruit(new Apple());
        System.out.println(boxApple.getBoxWeight());

        //2
        Box<Orange> boxOrange = new Box<>();
        boxOrange.putFruit(new Orange());
        boxOrange.putFruit(new Orange());

        System.out.println(boxApple.compare(boxOrange));

        //3
        Box<Apple> boxApple2 = new Box<>();
        boxApple.putFruit(new Apple());
        boxApple.putFruit(new Apple());

        boxApple.intersperse(boxApple2);
        System.out.println(boxApple.countInfo());
        System.out.println(boxApple2.countInfo());


    }
}
