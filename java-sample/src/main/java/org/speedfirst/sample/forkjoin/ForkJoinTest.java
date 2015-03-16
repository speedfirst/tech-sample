package org.speedfirst.sample.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Use the -Xmx to increase the heap size before run the test
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        int[] dataSet = prepare(200000000);
        doTest(1, dataSet);
        doTest(2, dataSet);
        doTest(4, dataSet);
        doTest(8, dataSet);
        doTest(16, dataSet);
        doTest(32, dataSet);
    }


    static void doTest(int parallelism, int[] dataSet) {
        MinValueTask t = new MinValueTask(dataSet, 0, dataSet.length - 1);
        ForkJoinPool p1 = new ForkJoinPool(parallelism);
        long start = System.nanoTime();
        p1.execute(t);
        long end = System.nanoTime();
        System.out.println("==============================");
        System.out.println(String.format("parallelism: %d, time: %dms", parallelism, (end - start) / 1000000));
    }

    static int[] prepare(int size) {
        int[] dataSet = new int[size];
        Random r = new Random();
        for (int i = 0; i < dataSet.length; i++) {
            dataSet[i] = r.nextInt(1000000);
        }
        return dataSet;
    }


}

class MinValueTask extends RecursiveTask<Integer> {

    private final int[] dataSet;

    private final int start;

    private final int end;

    private static final int THRESHOLD = 1000;

    public MinValueTask(int[] dataSet, int start, int end) {
        this.start = start;
        this.end = end;
        this.dataSet = dataSet;
    }

    @Override
    protected Integer compute() {

        if (end - start + 1 <= THRESHOLD) {
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                int value = dataSet[i];
                if (value < min) {
                    min = value;
                }
            }
            return min;
        } else {
            int mid = (end - start) / 2 + start;
            MinValueTask t1 = new MinValueTask(dataSet, start, mid);
            t1.fork();
            MinValueTask t2 = new MinValueTask(dataSet, mid + 1, end);
            return Math.min(t2.compute(), t1.join());
        }
    }
}
