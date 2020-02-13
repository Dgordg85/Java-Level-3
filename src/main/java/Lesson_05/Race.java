package Lesson_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Race {
    private CountDownLatch unReadyCars;
    private CountDownLatch notFinishCars;
    private ArrayBlockingQueue<Car> winner;

    private ArrayList<Stage> stages;

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        unReadyCars = new CountDownLatch(MainClass.CARS_COUNT);
        notFinishCars = new CountDownLatch(MainClass.CARS_COUNT);
        winner = new ArrayBlockingQueue<>(1);
    }

    public ArrayList<Stage> getStages(){
        return stages;
    }

    public CountDownLatch getUnReadyCars() {
        return unReadyCars;
    }

    public CountDownLatch getNotFinishCars() {
        return notFinishCars;
    }

    public ArrayBlockingQueue<Car> getWinner() {
        return winner;
    }
}
