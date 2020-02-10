package Lesson_04;

public class MFU {
    private volatile boolean isScanning = false;
    private volatile boolean isPrinting = false;

    public static void main(String[] args) {
        MFU mfu = new MFU();

        for (int i = 0; i < 2; i++) {
            mfu.print();
            mfu.scan();
            mfu.print();
        }
    }

    private synchronized void print(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Хочу распечатать...");
                while (isPrinting){
                    try {
                        System.out.println("Принтер занят жду...");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    isPrinting = true;
                    System.out.println("Печатаю");
                    Thread.sleep(1500);
                    System.out.println("Распечатал");
                    isPrinting = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
            }
        }).start();
    }

    private synchronized void scan(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Хочу просканировать...");
                while (isScanning){
                    try {
                        System.out.println("Сканер занят жду...");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    isScanning = true;
                    System.out.println("Сканирую");
                    Thread.sleep(2500);
                    System.out.println("Отсканировал");
                    isScanning = false;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
            }
        }).start();
    }
}
