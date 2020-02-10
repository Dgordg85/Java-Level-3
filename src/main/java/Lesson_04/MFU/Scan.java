package Lesson_04.MFU;

public class Scan extends Thread {
    private static volatile Boolean isScanning = false;

    @Override
    public void run() {
        synchronized (isScanning) {
            System.out.println(this.getName() + " Хочу просканировать...");
            while (isScanning) {
                try {
                    System.out.println(this.getName() + " Сканер занят жду...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {

                isScanning = true;
                System.out.println(this.getName() + " Сканирую");
                Thread.sleep(2500);
                System.out.println(this.getName() + " Просканировал");
                isScanning = false;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
