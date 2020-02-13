package Lesson_05;

public class MFU {
    Object print = new Object();
    Object scan = new Object();

    public static void main(String[] args) {
        MFU mfu = new MFU();

        int k = 1;
        for (int i = 0; i < 2; i++) {
            mfu.copy(k++, false);
            mfu.print(k++);
            mfu.copy(k++, true);
        }
    }

    private void print(int k){
        System.out.println("Жду печать " + k);
        new Thread(() -> {
            synchronized (print){
                try {
                    System.out.println(k + " Печатаю");
                    Thread.sleep(1500);
                    System.out.println(k + " Напечатал");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void copy(int k, boolean isPrint) {
        System.out.println("Жду копирования " + k);
        System.out.println("Жду сканирование " + k);

        Thread t1 = new Thread(() -> {
            synchronized (scan){
                try {
                    System.out.println(k + " Сканирую");
                    Thread.sleep(2500);
                    System.out.println(k + " Просканировал");
                    if (!isPrint) System.out.println("Отправлено на e-mail " + k);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        if (isPrint){
            synchronized (print){
                t1.start();
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print(k);
            }
        } else {
            t1.start();
        }
    }
}
