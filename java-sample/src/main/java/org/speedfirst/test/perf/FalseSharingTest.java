package org.speedfirst.test.perf;

public final class FalseSharingTest implements Runnable {
    public final static int NUM_THREADS = 4; // change
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;

    private static VolatilePaddingLong[] paddingLongs = new VolatilePaddingLong[NUM_THREADS];

    private static VolatileNativeLong[] nativeLongs = new VolatileNativeLong[NUM_THREADS];

    static {
        for (int i = 0; i < paddingLongs.length; i++) {
            paddingLongs[i] = new VolatilePaddingLong();
        }

        for (int i = 0; i < nativeLongs.length; i++) {
            nativeLongs[i] = new VolatileNativeLong();
        }
    }

    public FalseSharingTest(final int arrayIndex, boolean withPadding) {
        this.arrayIndex = arrayIndex;
        this.withPadding = withPadding;
    }

    private boolean withPadding;

    public static void main(final String[] args) throws Exception {
        System.out.println("========= With Padding ==========");
        final long start = System.nanoTime();
        runTest(true);
        System.out.println(String.format("duration = %,dns", (System.nanoTime() - start)));
        System.out.println();
        System.out.println("========= Without Padding ========");
        final long start2 = System.nanoTime();
        runTest(false);
        System.out.println(String.format("duration = %,dns", (System.nanoTime() - start2)));
    }

    private static void runTest(boolean withPadding) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharingTest(i, withPadding));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    public void run() {
        if (withPadding) {
            doRunForPadding();
        } else {
            doRunForNative();
        }
    }

    public void doRunForPadding() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            paddingLongs[arrayIndex].value = i;
        }
    }

    public void doRunForNative() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            nativeLongs[arrayIndex].value = i;
        }
    }

    public final static class VolatilePaddingLong {
        public volatile long value = 0L;
        public long p1, p2, p3, p4, p5, p6; // padding
    }

    public final static class VolatileNativeLong {
        public volatile long value = 0L;
    }
}
