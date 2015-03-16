package org.speedfirst.sample;

/**
 * Created by jiankuan on 9/28/14.
 */
public class EndlessFinalizer {

    byte[] memoryHog = new byte[1024 * 1024];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + this + " in thread " + Thread.currentThread());
        for (;;);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new EndlessFinalizer();
        }
    }

}
