package Lesson_04.MFU;

public class Print extends Thread {
    private static volatile Boolean isPrinting = false;

    @Override
    public void run() {
        synchronized (isPrinting) {
            System.out.println(this.getName() + " Хочу распечатать...");
            while (isPrinting) {
                try {
                    System.out.println(this.getName() + " Принтер занят жду...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                isPrinting = true;
                System.out.println(this.getName() + " Печатаю");
                Thread.sleep(1500);
                System.out.println(this.getName() + " Распечатал");
                isPrinting = false;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
