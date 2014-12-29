package org.speedfirst.test;

/**
 * Created by jiankuan on 11/19/14.
 */
public class VolatileVisibilityTest {

    public final long[] values = {1, 9};

    //public volatile boolean flag = false;

    class Updater implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                values[0]++;
                values[1]++;
                System.out.println(String.format("%d: values changes to %d, %d", i, values[0], values[1]));
//                if (i == 9000) {
//                    System.out.println("XXXX set flag");
//                    flag = true;
//                }

            }
        }
    }

    class Reader implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println(String.format("%d: values are %d, %d", i, values[0], values[1]));
            }
        }
    }

    public void runTest() {
        Thread updaterThread = new Thread(new Updater());
        Thread readerThread = new Thread(new Reader());
        updaterThread.start();
        readerThread.start();
        try {
            updaterThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new VolatileVisibilityTest().runTest();
    }
}
