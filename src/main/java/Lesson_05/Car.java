package Lesson_05;

import java.util.concurrent.ArrayBlockingQueue;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static ArrayBlockingQueue<Car> readyCars;
    private static ArrayBlockingQueue<Car> winner;

    static {
        CARS_COUNT = 0;
        readyCars = new ArrayBlockingQueue<>(MainClass.CARS_COUNT);
        winner = new ArrayBlockingQueue<>(1);
    }

    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + ++CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            readyCars.add(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (getReadyCars() != MainClass.CARS_COUNT){}

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (winner.offer(this)){
            System.out.println(this.getName() + " - WIN");
        }
    }

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public static int getReadyCars() {
        return readyCars.size();
    }
}
