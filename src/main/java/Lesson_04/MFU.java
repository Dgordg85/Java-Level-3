package Lesson_04;

public class MFU {
    private static volatile Boolean isScanning = false;
    private static volatile Boolean isPrinting = false;

    public static void main(String[] args) {
        MFU mfu = new MFU();

        for (int i = 0; i < 2; i++) {
            mfu.print();
            mfu.scan();
            mfu.print();
        }
    }

    private void print(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (isPrinting) {
                    System.out.println("Хочу распечатать...");
                    while (isPrinting) {
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
                }
                notifyAll();
            }
        }).start();
    }

    private synchronized void scan(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (isScanning) {
                    System.out.println("Хочу просканировать...");
                    while (isScanning) {
                        try {
                            System.out.println("Сканер занят жду...");
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
                }
                notifyAll();
            }
        }).start();
    }
}
