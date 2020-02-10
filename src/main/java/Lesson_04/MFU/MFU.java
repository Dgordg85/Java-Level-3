package Lesson_04.MFU;

public class MFU {

    public static void main(String[] args) {
        MFU mfu = new MFU();
        for (int i = 0; i < 2; i++) {
            mfu.print();
            mfu.scan();
            mfu.print();
        }
    }

    private void print(){
        new Print().start();
    }

    private void scan(){
        new Scan().start();
    }
}
