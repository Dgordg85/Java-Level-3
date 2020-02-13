package Lesson_05;

import java.util.concurrent.ArrayBlockingQueue;

public class Tunnel extends Stage {

    private ArrayBlockingQueue<Car> bandwidth;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        bandwidth = new ArrayBlockingQueue<>(MainClass.CARS_COUNT / 2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);

                while (!bandwidth.offer(c)){
                    Thread.sleep(10);
                }

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                bandwidth.take();
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
