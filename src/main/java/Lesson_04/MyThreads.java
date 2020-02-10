package Lesson_04;

import java.io.PrintStream;

public class MyThreads extends Thread {
    private static volatile PrintStream ps = new PrintStream(System.out);
    private static volatile String lastChar = "";
    private PrintObject object;

    public MyThreads(PrintObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " запущен");
        synchronized (ps){
            for (int i = 0; i < object.getCount(); i++) {
                while (!object.canPrintLetter(lastChar, this)){
                    try {
                        System.out.println(this.getName() + " не моя очередь, ожидаю.");
                        ps.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.getName() + " пишу в поток");
                lastChar = object.printLetter(ps);
                ps.notifyAll();
            }
        }
    }
}
