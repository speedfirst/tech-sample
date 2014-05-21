package org.speedfirst.test;

import java.sql.Time;

/**
 * Test string concat method in Java
 * StringBuilderTest start
 * total time 24.517000ms, time per run 0.000025ms

 * StringBufferTest start
 * total time 34.651000ms, time per run 0.000035ms
 *
 * StringRawConcatTest start
 * total time 682862.243000ms, time per run 0.682862ms
 *
 * StringConcatMethodTest start
 * total time 454060.188000ms, time per run 0.454060ms
 */
public class StringConcatTest {
    public static void main(String[] args) {
        new StringBuilderTest().run();
        new StringBufferTest().run();
        new StringRawConcatTest().run();
        new StringConcatMethodTest().run();
    }

    public static abstract class TimedTest {
        int COUNT = 1000000;

        public void run() {
            System.out.println(this.getClass().getSimpleName() + " start");
            long start = System.nanoTime();
            doRun();
            long end = System.nanoTime();
            double dur = (end - start) / 1000000.0;
            double durPerRun = dur / COUNT;
            System.out.println(String.format("total time %fms, time per run %fms\n", dur, durPerRun));
        }

        abstract void doRun();
    }

    public static class StringBuilderTest extends TimedTest {

        @Override
        void doRun() {
            String str = "";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < COUNT; i++) {
                sb.append("abc");
            }
        }
    }

    public static class StringBufferTest extends TimedTest {

        @Override
        void doRun() {
            String str = "";
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < COUNT; i++) {
                sb.append("abc");
            }
        }
    }

    public static class StringRawConcatTest extends TimedTest {

        @Override
        void doRun() {
            String str = "";
            for (int i = 0; i < COUNT; i++) {
                str += "abc";
            }
        }
    }

    public static class StringConcatMethodTest extends TimedTest {
        @Override
        void doRun() {
            String str = "";
            for (int i = 0; i < COUNT; i++) {
                str = str.concat("abc");
            }
        }
    }
}
